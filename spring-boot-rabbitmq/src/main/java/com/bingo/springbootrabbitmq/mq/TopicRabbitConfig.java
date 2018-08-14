package com.bingo.springbootrabbitmq.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:16
 * @Description: Topic 方式配置
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue topicMessageQueue() {
        return new Queue(RabbitMQConstant.QUEUE_TOPIC_MESSAGE);
    }

    @Bean
    public Queue topicMessagesQueue() {
        return new Queue(RabbitMQConstant.QUEUE_TOPIC_MESSAGES);
    }

    @Bean
    TopicExchange getExchange() {
        return new TopicExchange(RabbitMQConstant.EXCHANGE_TOPIC);
    }

    @Bean
    Binding bindingExchangeMessage(Queue topicMessageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessageQueue).to(topicExchange).with(RabbitMQConstant.QUEUE_TOPIC_MESSAGE);
    }

    @Bean
    Binding bindingExchangeMessages(Queue topicMessagesQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessagesQueue).to(topicExchange).with(RabbitMQConstant.ROUTING_TOPIC_MESSAGE_ALL);
    }

}
