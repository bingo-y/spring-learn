package com.bingo.springbootrabbitmq.mq.fanout;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:23
 * @Description: Fanout消息接收
 */
@Component
@RabbitListener(queues = RabbitMQConstant.QUEUE_FANOUT_A)
public class FanoutAReceiver {

    Logger logger = LoggerFactory.getLogger(FanoutAReceiver.class);

    @RabbitHandler
    public void receiver(String message) {
        logger.info("FanoutA receiver: {}", message);
    }

}
