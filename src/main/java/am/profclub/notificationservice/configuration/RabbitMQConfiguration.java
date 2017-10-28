package am.profclub.notificationservice.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.xml.LoggingChannelAdapterParser;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;

//@EnableConfigurationProperties(ServiceProperties.class)
public class RabbitMQConfiguration {

    @Bean
    public DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel eventChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel trackLogChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow integrationFlow(RabbitMQEndpoint endpoint) {
        return IntegrationFlows.from(eventChannel())
                .wireTap(trackLogChannel()).log(LoggingHandler.Level.INFO)
                .channel(inputChannel())
                    .handle(endpoint).log(LoggingHandler.Level.ERROR)
                        .get();
    }

}
