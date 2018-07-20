package com.bingo.springbootrabbitmq.mq.simple;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
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

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(String message) {
        System.out.println("send string message: " + message);
        amqpTemplate.convertAndSend(RabbitMQConstant.STRING_QUEUE, message);
    }

}
