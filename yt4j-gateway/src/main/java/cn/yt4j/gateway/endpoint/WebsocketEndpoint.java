package cn.yt4j.gateway.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 前端启动直接构建websocket连接，各个系统可以通过redis发布订阅的方式，直接将消息放到
 *
 * @author gyv12345@163.com
 */
@Slf4j
@ServerEndpoint(value = "/websocket/endpoint", port = "11111")
public class WebsocketEndpoint {

	public static ConcurrentHashMap<String, Session> concurrentHashMap = new ConcurrentHashMap<>();

	@BeforeHandshake
	public void handshake(Session session, HttpHeaders headers, @RequestParam String userKey) {
		session.setSubprotocols("stomp");
	}

	@OnOpen
	public void onOpen(Session session, HttpHeaders headers, @RequestParam String userKey) {
		if (!StringUtils.hasText(userKey)) {
			concurrentHashMap.remove(userKey);
		}
		concurrentHashMap.put(userKey, session);
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		session.sendText("关闭");
		concurrentHashMap.forEach((key, obj) -> {
			if (obj.equals(session)) {
				concurrentHashMap.remove(key);
			}
		});
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		session.sendText("{\"message\":1}");
	}

	@OnBinary
	public void onBinary(Session session, byte[] bytes) {
		session.sendBinary(bytes);
	}

	@OnEvent
	public void onEvent(Session session, Object evt) {
		if (evt instanceof IdleStateEvent idleStateEvent) {
			switch (idleStateEvent.state()) {
				case READER_IDLE:
					log.info("read idle");
					break;
				case WRITER_IDLE:
					log.info("write idle");
					break;
				case ALL_IDLE:
					log.info("all idle");
					break;
				default:
					break;
			}
		}
	}

	public static void send(Object message, String userKey) {
		ObjectMapper mapper = new ObjectMapper();
		if (concurrentHashMap.containsKey(userKey)) {
			try {
				concurrentHashMap.get(userKey).sendText(mapper.writeValueAsString(message));
			}
			catch (JsonProcessingException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

}
