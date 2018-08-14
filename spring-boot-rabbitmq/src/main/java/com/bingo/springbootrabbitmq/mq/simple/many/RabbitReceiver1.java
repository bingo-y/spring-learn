package com.bingo.springbootrabbitmq.mq.simple.many;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:23
 * @Description: 消息接收
 */
@Component
@RabbitListener(queues = RabbitMQConstant.QUEUE_MANY)
public class RabbitReceiver1 {

    Logger logger = LoggerFactory.getLogger(RabbitReceiver1.class);

    @RabbitHandler
    public void receiver(String message) throws InterruptedException {
        logger.info("RabbitReceiver1 receiver: {}", message);
}

}
