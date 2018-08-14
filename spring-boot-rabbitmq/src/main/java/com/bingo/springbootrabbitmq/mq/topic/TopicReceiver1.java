package com.bingo.springbootrabbitmq.mq.topic;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TopicReceiver1.class);

    @RabbitHandler
    public void receiver(String message) {
        logger.info("receiver1 message: {}", message);
    }

}
