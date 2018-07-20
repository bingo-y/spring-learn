package com.bingo.springbootrabbitmq.mq.simple;

import com.bingo.springbootrabbitmq.model.User;
import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:40
 * @Description: 点对点发送对象消息
 */
@Component
public class ObjectSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(User user) {
        System.out.println("send user message: " + user.toString());
        amqpTemplate.convertAndSend(RabbitMQConstant.OBJECT_QUEUE, user);
    }

}
