package cn.yt4j.sys.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

	/**
	 * Creates new {@link } for {@code __keyevent@*__:expired} messages.
	 * @param listenerContainer must not be {@literal null}.
	 */
	public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}

	/**
	 * 针对redis数据失效事件，进行数据处理
	 * @param message
	 * @param pattern
	 */
	@Override
	public void onMessage(Message message, byte[] pattern) {
		// 获得失效的key
		System.out.println("onMessage pattern " + pattern + " " + " " + message);
		String channel = new String(message.getChannel());
		System.out.println(channel);
	}

}
