package cn.yt4j.ai.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class CozeApiUtil {

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 问问题
	 * @param body
	 * @return
	 */
	@SneakyThrows
	public String question(Object body, String token) {
		HttpRequest request = new HttpRequest("https://api.coze.com/v3/chat");
		request.setMethod(Method.POST);

		String contentType = "application/json";

		request.header("Content-Type", contentType);
		request.header("Authorization", "Bearer " +token);

		if (ObjectUtil.isNotEmpty(body)) {
			request.body(objectMapper.writeValueAsString(body));
			log.info("发送请求:{}", objectMapper.writeValueAsString(body));
		}

		String result = request.execute().body();
		log.info("调用COZE返回：{}", result);
		return result;
	}

	/**
	 * 获取答案
	 */
	public String getAnswer(String chatId, String conversationId,String token) {
		HttpRequest request = new HttpRequest("https://api.coze.com/v3/chat/message/list");
		request.setMethod(Method.GET);

		String contentType = "application/json";

		request.header("Content-Type", contentType);
		request.header("Authorization", "Bearer " + token);

		Map<String, Object> map = new HashMap<>();
		map.put("chat_id", chatId);
		map.put("conversation_id", conversationId);

		request.form(map);
		String result = request.execute().body();
		log.info("调用COZE返回：{}", result);
		return result;
	}

}
