package com.bingo.springbootrabbitmq.mq.simple;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:23
 * @Description: String消息接收
 */
@Component
@RabbitListener(queues = RabbitMQConstant.STRING_QUEUE)
public class StringReceiver {

    @RabbitHandler
    public void receiver(String message) {
        System.out.println("receiver string message: " + message);
    }

}
