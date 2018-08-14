package com.bingo.springbootrabbitmq.mq.simple;

import com.bingo.springbootrabbitmq.model.User;
import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:44
 * @Description:
 */
@Component
@RabbitListener(queues = RabbitMQConstant.QUEUE_OBJECT)
public class ObjectReceiver {

    Logger logger = LoggerFactory.getLogger(ObjectSender.class);

    @RabbitHandler
    public void receiver(User user) {
        logger.info("receiver user: {}", user.toString());
    }

}
