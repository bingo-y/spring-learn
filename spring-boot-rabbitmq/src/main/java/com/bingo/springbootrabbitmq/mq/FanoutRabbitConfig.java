package com.bingo.springbootrabbitmq.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 17:41
 * @Description: Fanout (广播 订阅)
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(RabbitMQConstant.QUEUE_FANOUT_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(RabbitMQConstant.QUEUE_FANOUT_B);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQConstant.EXCHANGE_FANOUT);
    }

    @Bean
    Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

}
