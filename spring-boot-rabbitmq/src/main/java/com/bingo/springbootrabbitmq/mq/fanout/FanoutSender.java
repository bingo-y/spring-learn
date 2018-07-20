package com.bingo.springbootrabbitmq.mq.fanout;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
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

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendA(String message) {
        System.out.println("send fanout a: " + message);
        amqpTemplate.convertAndSend(RabbitMQConstant.FANOUT_EXCHANGE, RabbitMQConstant.FANOUT_A_QUEUE, message);
    }

    public void sendB(String message) {
        System.out.println("send fanout a: " + message);
        amqpTemplate.convertAndSend(RabbitMQConstant.FANOUT_EXCHANGE, RabbitMQConstant.FANOUT_B_QUEUE, message);
    }

}
