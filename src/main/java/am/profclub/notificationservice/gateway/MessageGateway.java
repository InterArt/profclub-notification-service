package am.profclub.notificationservice.gateway;

import am.profclub.notificationservice.common.Event;
import org.springframework.integration.annotation.Gateway;

public interface MessageGateway {

	@Gateway(requestChannel="eventChannel")
	public void process(Event event);
}
