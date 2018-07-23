package com.bingo.springbootrabbitmqack.controller;

import com.bingo.springbootrabbitmqack.model.User;
import com.bingo.springbootrabbitmqack.mq.RabbitServerConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: tyx
 * @Date: create in 2018/7/23 14:39
 * @Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String sendDirect(@RequestParam("name") String name) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName(name);
            user.setAge(18 + i);
            rabbitTemplate.convertAndSend(RabbitServerConfig.EXCHANGE_DIRECT, RabbitServerConfig.ROUTING_DIRECT, user, correlationData);
        }
        return "ok";
    }

    @RequestMapping("/send/dead/letter")
    public String sendDeadLetter(@RequestParam("name") String name) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitServerConfig.EXCHANGE_DL, RabbitServerConfig.ROUTING_DL, name, correlationData);
        return "ok";
    }

}
