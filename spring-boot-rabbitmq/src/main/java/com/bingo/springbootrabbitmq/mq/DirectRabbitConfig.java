package com.bingo.springbootrabbitmq.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tyx
 * @Date: create in 2018/7/20 18:20
 * @Description: 与topic一起用时，Direct无法绑定
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueue() {
        return new Queue(RabbitMQConstant.QUEUE_DIRECT);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConstant.EXCHANGE_DIRECT);
    }


    @Bean
    Binding bindingExchangeMessage(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(RabbitMQConstant.ROUTING_DIRECT);
    }

}
