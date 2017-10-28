package am.profclub.notificationservice.service;

import am.profclub.notificationservice.common.Event;
import am.profclub.notificationservice.gateway.MessageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private MessageGateway messageGateway;

    public void sendMessage(Event event) {
        messageGateway.process(event);
    }
}
