package com.bingo.springbootrabbitmq.mq.simple.many;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:23
 * @Description: 消息接收
 */
@Component
@RabbitListener(queues = RabbitMQConstant.MANY_QUEUE)
public class RabbitReceiver1 {

    @RabbitHandler
    public void receiver(String message) {
        System.out.println("RabbitReceiver1 receiver message: " + message);
    }

}
