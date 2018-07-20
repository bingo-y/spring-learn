package com.bingo.springbootrabbitmq.mq.simple;

import com.bingo.springbootrabbitmq.model.User;
import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:44
 * @Description:
 */
@Component
@RabbitListener(queues = RabbitMQConstant.OBJECT_QUEUE)
public class ObjectReceiver {

    @RabbitHandler
    public void receiver(User user) {
        System.out.println("receiver user: " + user.toString());
    }

}
