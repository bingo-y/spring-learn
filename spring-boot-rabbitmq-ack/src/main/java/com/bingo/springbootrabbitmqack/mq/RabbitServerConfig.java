package com.bingo.springbootrabbitmqack.mq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tyx
 * @Date: create in 2018/7/23 14:16
 * @Description:
 */
@Configuration
public class RabbitServerConfig {

    public final static String QUEUE_DIRECT = "queue.bingo.direct";
    public final static String ROUTING_DIRECT = "routing.bingo.direct";
    public final static String EXCHANGE_DIRECT = "exchange.bingo.direct";

    public final static String QUEUE_DL = "queue.bingo.dl";
    public final static String ROUTING_DL = "routing.bingo.dl";
    public final static String EXCHANGE_DL = "exchange.bingo.dl";
    public final static String QUEUE_REDIRECT = "queue.bingo.redirect";
    public final static String ROUTING_REDIRECT = "routing.bingo.redirect";

    /**
     * 死信队列 交换机标识符
     */
    private static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    /**
     * 死信队列交换机绑定键标识符
     */
    private static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /**
     * 声明一个队列 支持持久化.
     *
     * @return the queue
     */
    @Bean("directQueue")
    public Queue directQueue() {
        return QueueBuilder.durable(QUEUE_DIRECT).build();
    }

    /**
     * 声明直连交换机 支持持久化.
     *
     * @return the exchange
     */
    @Bean("directExchange")
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT).durable(true).build();
    }

    @Bean
    public Binding bindQueueToExchange(@Qualifier("directQueue") Queue queue, @Qualifier("directExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_DIRECT).noargs();
    }

    /************* dead letter queue *************/

    /**
     * 声明一个死信队列.
     * x-dead-letter-exchange   对应  死信交换机
     * x-dead-letter-routing-key  对应 死信队列
     *
     * @return the queue
     */
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // x-dead-letter-exchange    声明  死信交换机
        args.put(DEAD_LETTER_QUEUE_KEY, EXCHANGE_DL);
        // x-dead-letter-routing-key    声明 死信路由键
        args.put(DEAD_LETTER_ROUTING_KEY, ROUTING_DIRECT);
        return QueueBuilder.durable(QUEUE_DL).withArguments(args).build();
    }

    /**
     * 死信转发队列
     * @return queue
     */
    @Bean("redirectQueue")
    public Queue redirectQueue() {
        return QueueBuilder.durable(QUEUE_REDIRECT).build();
    }

    /**
     * 死信队列跟交换机类型没有关系 不一定为directExchange  不影响该类型交换机的特性.
     *
     * @return the exchange
     */
    @Bean("deadLetterExchange")
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_DL).durable(true).build();
    }

    /**
     * 死信路由通过 DL_KEY 绑定键绑定到死信队列上.
     *
     * @return the binding
     */
    @Bean
    Binding deadLetterBinding() {
        return new Binding(QUEUE_DL, Binding.DestinationType.QUEUE, EXCHANGE_DL, ROUTING_DL, null);
    }

    /**
     * 死信路由通过 转发路由key 绑定键绑定到死信转发队列上.
     *
     * @return the binding
     */
    @Bean
    public Binding redirectBinding() {
        return new Binding(QUEUE_REDIRECT, Binding.DestinationType.QUEUE, EXCHANGE_DL, ROUTING_DIRECT, null);
    }

}
