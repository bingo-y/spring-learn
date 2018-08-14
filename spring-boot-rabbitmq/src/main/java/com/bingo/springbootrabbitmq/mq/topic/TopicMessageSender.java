package com.bingo.springbootrabbitmq.mq.topic;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:18
 * @Description: 点对点发送String消息
 */
@Component
public class TopicMessageSender {

    Logger logger = LoggerFactory.getLogger(TopicMessageSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        logger.info("send message1: {}",  message);
        amqpTemplate.convertAndSend(RabbitMQConstant.TOPIC_EXCHANGE, RabbitMQConstant.TOPIC_MESSAGE_QUEUE, message);
    }

    public void sendMessage2(String message) {
        logger.info("send message2: {}",  message);
        amqpTemplate.convertAndSend(RabbitMQConstant.TOPIC_EXCHANGE, RabbitMQConstant.TOPIC_MESSAGES_QUEUE, message);
    }

    public void sendMessage3(String message) {
        logger.info("send message3: {}",  message);
        amqpTemplate.convertAndSend(RabbitMQConstant.TOPIC_EXCHANGE, RabbitMQConstant.TOPIC_MESSAGE_1_QUEUE, message);
    }

}
