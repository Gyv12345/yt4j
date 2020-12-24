package cn.yt4j.pubsub.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author gyv12
 */
@Component
public class UserListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
