package top.mixedinfos.rabbitmqconsumer.fanout_consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutMessageReceiver2 {

    @RabbitListener(queues = "queues.fanout")
    public void directMessageConsumer(String msg){
        System.out.println("222222----Fanout模式接受的消息为："+msg);
    }
}
