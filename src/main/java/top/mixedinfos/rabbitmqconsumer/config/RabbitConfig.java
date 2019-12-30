package top.mixedinfos.rabbitmqconsumer.config;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 对发送消息的确认
 */
@Service("rabbitConfig")
@Component
public class RabbitConfig implements ChannelAwareMessageListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 对消息的手动处理
     * @param message
     * @param channel
     * @throws Exception
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息\
        System.out.println(message);
        System.out.println(channel);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        // ack返回false，并重新回到队列，api里面解释得很清楚
        // channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        // 拒绝消息
        // channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
    }
}

