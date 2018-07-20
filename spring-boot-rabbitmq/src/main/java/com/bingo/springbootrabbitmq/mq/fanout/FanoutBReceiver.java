package com.bingo.springbootrabbitmq.mq.fanout;

import com.bingo.springbootrabbitmq.mq.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:23
 * @Description: Fanout消息接收
 */
@Component
@RabbitListener(queues = RabbitMQConstant.FANOUT_B_QUEUE)
public class FanoutBReceiver {

    @RabbitHandler
    public void receiver(String message) {
        System.out.println("FanoutBReceiver receiver: " + message);
    }

}
