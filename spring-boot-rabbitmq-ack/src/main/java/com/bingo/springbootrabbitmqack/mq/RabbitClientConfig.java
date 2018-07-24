package com.bingo.springbootrabbitmqack.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tyx
 * @Date: create in 2018/7/23 10:54
 * @Description:
 */
@Configuration
public class RabbitClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(RabbitClientConfig.class);


    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 定制化amqp模版      可根据需要定制多个
     * <p>
     * 此处为模版类定义 Jackson消息转换器
     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     *
     * @return the amqp template
     */
    @Bean
    public AmqpTemplate amqpTemplate() {
        // 消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        // 开启returncallback yml 需要 配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                String correlationId = message.getMessageProperties().getCorrelationId();
                logger.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
            }
        });
        // 消息确认 yml 需要配置 publisher-returns: true
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    logger.debug("消息发送到exchange成功,id: {}", correlationData.getId());
                } else {
                    logger.debug("消息发送到exchange失败,原因: {}", cause);
                }
            }
        });
        return rabbitTemplate;
    }
}
