package com.bingo.springbootrabbitmq.mq.simple.many;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
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

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(Integer index) {
        String message = "RabbitSender1 send message: " + index;
        System.out.println(message);
        amqpTemplate.convertAndSend(RabbitMQConstant.MANY_QUEUE, message);
    }

}
