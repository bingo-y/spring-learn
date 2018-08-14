package com.bingo.springbootrabbitmq.mq;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:21
 * @Description:
 */
public class RabbitMQConstant {

    public static final String ROUTING_STRING = "bingo.string";
    public static final String QUEUE_STRING = "bingo.string";

    public static final String ROUTING_OBJECT = "bingo.object";
    public static final String QUEUE_OBJECT = "bingo.object";

    public static final String ROUTING_MANY = "bingo.many";
    public static final String QUEUE_MANY = "bingo.many";

    public static final String QUEUE_TOPIC_MESSAGE = "bingo.topic.message";
    public static final String QUEUE_TOPIC_MESSAGES = "bingo.topic.message2";
    public static final String ROUTING_TOPIC_MESSAGE_ALL = "bingo.topic.#";
    public static final String QUEUE_TOPIC_MESSAGE_1 = "bingo.topic.1";

    public static final String QUEUE_DIRECT = "bingo.direct";
    public static final String ROUTING_DIRECT = "bingo.direct";
    public static final String EXCHANGE_DIRECT = "direct_exchange";

    public static final String QUEUE_FANOUT_A = "bingo.fanout.a";
    public static final String QUEUE_FANOUT_B = "bingo.fanout.b";

    public static final String EXCHANGE_TOPIC = "topic_exchange";
    public static final String EXCHANGE_FANOUT = "fanout_exchange";

}
