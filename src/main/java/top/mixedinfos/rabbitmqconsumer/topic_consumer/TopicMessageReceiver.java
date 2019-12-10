package top.mixedinfos.rabbitmqconsumer.topic_consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                    value = "queues.topic"
                        ,
                    autoDelete = "false" //此模式为true的时候会随着应用的退出，销毁队列
                ),
                exchange = @Exchange(
                        value = "${messageQueue.exchangeTopicName}",
                        type = ExchangeTypes.TOPIC
                ),
                key = "mytopickey.message"
        )
)
public class TopicMessageReceiver {

    @RabbitHandler
    public void directMessageConsumer(String msg){
        System.out.println("TopicMessageReceiver模式接受的消息为："+msg);
    }

}
