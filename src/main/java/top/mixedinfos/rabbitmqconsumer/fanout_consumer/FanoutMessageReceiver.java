package top.mixedinfos.rabbitmqconsumer.fanout_consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class FanoutMessageReceiver {

    @RabbitListener(queues = "queues.fanout")
    public void directMessageConsumer(String msg){
        System.out.println("111111----Fanout模式接受的消息为："+msg);
    }

}
