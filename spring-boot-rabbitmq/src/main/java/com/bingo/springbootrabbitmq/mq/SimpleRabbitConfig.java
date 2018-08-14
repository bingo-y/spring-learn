package com.bingo.springbootrabbitmq.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:35
 * @Description:
 */
@Configuration
public class SimpleRabbitConfig {

    @Bean
    public Queue stringQueue() {
        return new Queue(RabbitMQConstant.QUEUE_STRING);
    }

    @Bean
    public Queue objectQueue() {
        return new Queue(RabbitMQConstant.QUEUE_OBJECT);
    }

    @Bean
    public Queue manyQueue() {
        return new Queue(RabbitMQConstant.QUEUE_MANY);
    }

}
