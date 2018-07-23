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
        log.debug("message arrive");
        Thread.sleep(10L);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("DIRECT " + new String (message.getBody()));
        log.debug("message listener thread: " + Thread.currentThread().getName());
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
        log.debug("QUEUE_DL arrive");
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("DEAD LETTER " + new String (message.getBody()));
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
        log.debug("QUEUE_REDIRECT arrive");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("DEAD LETTER REDIRECT " + new String (message.getBody()));
    }

}
