package am.profclub.notificationservice.configuration;

import am.profclub.notificationservice.service.Consumer;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;

/**
 * Created by ARTHUR on 10/29/2017.
 */
public class RabbitMQConfig {

    public final static String publishQName ="publishQueue";
    public final static String consumeQName ="consumeQueue";

    //@Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        Jackson2JsonMessageConverter con= new Jackson2JsonMessageConverter();
        return con;
    }
    //@Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate templete=new RabbitTemplate();
        templete.setExchange("exchange");//Set exchange
        templete.setQueue(publishQName);//Declare queue
        templete.setMessageConverter(jsonMessageConverter());
        templete.setConnectionFactory(connectionFactory);
        return templete;
    }
    //@Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(consumeQName);
        container.setMessageConverter(jsonMessageConverter());
        container.setMessageListener(consumer());
        return container;
    }
    //@Bean
    MessageListener consumer(){
        return new Consumer();
    }
}
