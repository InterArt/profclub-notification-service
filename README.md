#### RabbitMQ Docker install
docker run -d --hostname my-rabbit --name notification-service-rabbit -p 15672:15672 -e RABBITMQ_DEFAULT_USER=peirabbitmquser -e RABBITMQ_DEFAULT_PASS=peirabbitmqpswd rabbitmq:3-management
Help Url : https://hub.docker.com/_/rabbitmq/

#### Management console
http://192.168.99.100:15672
username: peirabbitmquser
password: peirabbitmqpswd

