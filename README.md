"# profclub-notification-service" 

### Help Url 
https://spring.io/guides/gs/messaging-rabbitmq/
https://github.com/spring-projects/spring-integration-samples/tree/master/basic/amqp#spring-integration-adapters


## Rabbit MQ Docker helper
#### Simple  
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3

#### Advanced
docker run -d --hostname my-rabbit --name notification-service-rabbit -p 15672:15672 -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management
Help Url : https://hub.docker.com/_/rabbitmq/

