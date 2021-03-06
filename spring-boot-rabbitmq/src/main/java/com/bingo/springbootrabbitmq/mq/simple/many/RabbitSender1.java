package com.bingo.springbootrabbitmq.mq.simple.many;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import com.bingo.springbootrabbitmq.mq.simple.ObjectSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:55
 * @Description: 多消息队列
 */
@Component
public class RabbitSender1 {

    Logger logger = LoggerFactory.getLogger(RabbitSender1.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(Integer index) {
        String message = "sender1 message" + index;
        logger.info(message);
        amqpTemplate.convertAndSend(RabbitMQConstant.ROUTING_MANY, message);
    }

}
