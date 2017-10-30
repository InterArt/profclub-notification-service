package am.profclub.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer implements MessageListener {
    private final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void onMessage(Message message) {
        String parseMessage = new String(message.getBody());
        log.info("consumer message {}", parseMessage);
    }
}