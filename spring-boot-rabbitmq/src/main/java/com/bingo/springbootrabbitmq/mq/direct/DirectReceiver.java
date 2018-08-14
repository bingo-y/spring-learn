package com.bingo.springbootrabbitmq.mq.direct;

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
public class DirectReceiver {

    Logger logger = LoggerFactory.getLogger(DirectSender.class);

    @RabbitListener(queues = RabbitMQConstant.DIRECT_QUEUE)
    public void receiver(String message) {
        logger.info("receiver1: {}", message);
    }

    @RabbitListener(queues = RabbitMQConstant.DIRECT_QUEUE)
    public void receiver2(String message) {
        logger.info("receiver2: {}", message);
    }

}
