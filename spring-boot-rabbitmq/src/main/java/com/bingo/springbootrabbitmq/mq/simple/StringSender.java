package com.bingo.springbootrabbitmq.mq.simple;

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
public class StringSender {

    Logger logger = LoggerFactory.getLogger(StringSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(String message) {
        logger.info("send string: {}", message);
        amqpTemplate.convertAndSend(RabbitMQConstant.ROUTING_STRING, message);
    }

}
