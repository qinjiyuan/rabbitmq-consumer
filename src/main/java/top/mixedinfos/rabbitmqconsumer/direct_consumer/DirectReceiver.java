package top.mixedinfos.rabbitmqconsumer.direct_consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                    value = "queues.direct"
//                        ,
//                    autoDelete = "true" //此模式为true的时候会随着应用的退出，销毁队列
                ),
                exchange = @Exchange(
                        value = "${messageQueue.exchangeDirectName}",
                        type = ExchangeTypes.DIRECT
                ),
                key = "${messageQueue.bindingDirectKey}"
        )
)
public class DirectReceiver {

    @RabbitHandler
    public void directMessageConsumer(String msg){
        System.out.println("direct模式接受的消息为："+msg);
    }

}
