package com.bingo.springbootrabbitmq.mq;

/**
 * @Author: tyx
 * @Date: create in 2018/7/19 16:21
 * @Description:
 */
public class RabbitMQConstant {

    public static final String STRING_QUEUE = "bingo.string";
    public static final String OBJECT_QUEUE = "bingo.object";
    public static final String MANY_QUEUE = "bingo.many";

    public static final String TOPIC_MESSAGE_QUEUE = "bingo.topic.message";
    public static final String TOPIC_MESSAGES_QUEUE = "bingo.topic.message2";
    public static final String TOPIC_MESSAGE_ALL_QUEUE = "bingo.topic.#";
    public static final String TOPIC_MESSAGE_1_QUEUE = "bingo.topic.1";

    public static final String DIRECT_QUEUE = "bingo.direct";
    public static final String DIRECT_ROUTING = "bingo.direct";
    public static final String DIRECT_EXCHANGE = "direct_exchange";

    public static final String FANOUT_A_QUEUE = "bingo.fanout.a";
    public static final String FANOUT_B_QUEUE = "bingo.fanout.b";

    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

}
