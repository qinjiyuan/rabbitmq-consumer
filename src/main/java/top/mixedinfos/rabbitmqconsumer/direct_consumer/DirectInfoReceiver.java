package top.mixedinfos.rabbitmqconsumer.direct_consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                    value = "${queues.direct.info}"
//                        ,
//                    autoDelete = "true" //此模式为true的时候会随着应用的退出，销毁队列
                ),
                exchange = @Exchange(
                        value = "${messageQueue.exchangeDirectName}",
                        type = ExchangeTypes.DIRECT
                ),
                key = "${queues.direct.info-routing-key}"
        )
)
public class DirectInfoReceiver {

    @RabbitHandler
    public void directMessageConsumer(String msg){
        System.out.println("direct模式接受的消息为："+msg);
    }

}
