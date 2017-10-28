package am.profclub.notificationservice.controller;

import am.profclub.notificationservice.common.Event;
import am.profclub.notificationservice.common.TestEvent;
import am.profclub.notificationservice.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @RequestMapping(method = RequestMethod.GET, value = "/send")
    public String sendMessage(@RequestParam String message) {
        try {
            Event event = new TestEvent(message);
            producer.sendMessage(event);
            return "Message has been sent";
        } catch (Exception e) {
            return "Exception during sent message";
        }
    }
}
