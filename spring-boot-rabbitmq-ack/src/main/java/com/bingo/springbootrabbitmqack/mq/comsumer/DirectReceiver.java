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
public class DirectReceiver {

    private static final Logger log= LoggerFactory.getLogger(DirectReceiver.class);

    /**
     * DIRECT模式.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {RabbitServerConfig.QUEUE_DIRECT})
    public void message(Message message, Channel channel) throws IOException, InterruptedException {
        log.info("message arrive");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("message: " + new String (message.getBody()));
        log.info("message listener thread id:{}, name:{}: ", Thread.currentThread().getId(), Thread.currentThread().getName());
    }

    /**
     * 死信队列
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {RabbitServerConfig.QUEUE_DL})
    public void deadLetter(Message message, Channel channel) throws IOException, InterruptedException {
        log.info("QUEUE_DL arrive");
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        log.info("DEAD LETTER " + new String (message.getBody()));
    }

    /**
     * 死信转发队列
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {RabbitServerConfig.QUEUE_REDIRECT})
    public void deadLetterRedirect(Message message, Channel channel) throws IOException, InterruptedException {
        log.info("QUEUE_REDIRECT arrive");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("DEAD LETTER REDIRECT " + new String (message.getBody()));
    }

}
