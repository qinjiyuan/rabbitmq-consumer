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
                    autoDelete = "true" //此模式为true的时候会随着应用的退出，销毁队列
                ),
                exchange = @Exchange(
                        value = "${messageQueue.exchangeTopicName}",
                        type = ExchangeTypes.TOPIC
                ),
                key = "mytopickey.play"
        )
)
public class TopicPlayReceiver {

    @RabbitHandler
    public void directMessageConsumer(String msg){
        System.out.println("TopicPlayReceiver模式接受的消息为："+msg);
    }

}
