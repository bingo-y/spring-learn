package com.bingo.springbootrabbitmq.mq.fanout;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 17:48
 * @Description:
 */
@Component
public class FanoutSender {

    Logger logger = LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendA(String message) {
        logger.info("send fanout a: {}", message);
        amqpTemplate.convertAndSend(RabbitMQConstant.FANOUT_EXCHANGE, RabbitMQConstant.FANOUT_A_QUEUE, message);
    }

    public void sendB(String message) {
        logger.info("send fanout b: {}", message);
        amqpTemplate.convertAndSend(RabbitMQConstant.FANOUT_EXCHANGE, RabbitMQConstant.FANOUT_B_QUEUE, message);
    }

}
