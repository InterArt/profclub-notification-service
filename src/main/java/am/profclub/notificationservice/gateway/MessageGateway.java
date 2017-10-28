package am.profclub.notificationservice.gateway;

import am.profclub.notificationservice.common.Event;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "eventChannel")
public interface MessageGateway {

	void process(Event event);
}
