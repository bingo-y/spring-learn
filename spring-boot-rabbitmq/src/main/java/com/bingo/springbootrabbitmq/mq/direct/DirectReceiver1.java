package com.bingo.springbootrabbitmq.mq.direct;

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
@RabbitListener(queues = RabbitMQConstant.DIRECT_QUEUE)
public class DirectReceiver1 {

    @RabbitHandler
    public void receiver(String message) {
        System.out.println("DirectReceiver1 receiver message: " + message);
    }

}
