package com.bingo.springbootrabbitmq.mq.direct;

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
public class DirectSender {

    Logger logger = LoggerFactory.getLogger(DirectSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        logger.info("send message: {}", message);
        amqpTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_DIRECT, RabbitMQConstant.ROUTING_DIRECT, message);
    }

}
