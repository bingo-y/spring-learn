package com.bingo.springbootrabbitmqack.mq.comsumer;

import com.bingo.springbootrabbitmqack.mq.RabbitServerConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: tyx
 * @Date: create in 2018/7/23 14:36
 * @Description:
 */
@Component
public class DirectReceiver2 {

    private static final Logger log= LoggerFactory.getLogger(DirectReceiver2.class);

    /**
     * DIRECT模式.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {RabbitServerConfig.QUEUE_DIRECT})
    public void message2(Message message, Channel channel) throws IOException {
        log.info("message2 arrive");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("message2: " + new String (message.getBody()));
        log.info("message2 listener thread id:{}, name:{}: ", Thread.currentThread().getId(), Thread.currentThread().getName());
    }

}
