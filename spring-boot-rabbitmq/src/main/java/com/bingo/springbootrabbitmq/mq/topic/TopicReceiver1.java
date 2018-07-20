package com.bingo.springbootrabbitmq.mq.topic;

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
@RabbitListener(queues = RabbitMQConstant.TOPIC_MESSAGE_QUEUE)
public class TopicReceiver1 {

    @RabbitHandler
    public void receiver(String message) {
        System.out.println("TopicReceiver1 receiver message: " + message);
    }

}
