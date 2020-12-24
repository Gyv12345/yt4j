package cn.yt4j.pubsub.config;

import cn.yt4j.core.constant.RedisConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author gyv12
 */
@Configuration
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(null, new ChannelTopic(RedisConstants.USER_TOPIC));
        return container;
    }
}
