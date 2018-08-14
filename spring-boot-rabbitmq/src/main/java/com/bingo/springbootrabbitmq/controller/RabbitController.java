package com.bingo.springbootrabbitmq.controller;

import com.bingo.springbootrabbitmq.model.User;
import com.bingo.springbootrabbitmq.mq.direct.DirectSender;
import com.bingo.springbootrabbitmq.mq.fanout.FanoutSender;
import com.bingo.springbootrabbitmq.mq.simple.ObjectSender;
import com.bingo.springbootrabbitmq.mq.simple.StringSender;
import com.bingo.springbootrabbitmq.mq.simple.many.RabbitSender1;
import com.bingo.springbootrabbitmq.mq.simple.many.RabbitSender2;
import com.bingo.springbootrabbitmq.mq.topic.TopicMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tyx
 * @Date: create in 2018/8/13 10:56
 * @Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    StringSender stringSender;
    @Autowired
    ObjectSender objectSender;
    @Autowired
    RabbitSender1 rabbitSender1;
    @Autowired
    RabbitSender2 rabbitSender2;

    @Autowired
    DirectSender directSender;

    @Autowired
    TopicMessageSender topicMessageSender;

    @Autowired
    FanoutSender fanoutSender;

    @RequestMapping("/simple/send/string")
    public ResponseEntity sendString(@RequestParam("name") String name) {
        stringSender.send(name);
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/simple/send/object")
    public ResponseEntity sendObj(@RequestParam("name") String name) {
        User user = new User(name, 18);
        objectSender.send(user);
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/simple/send/many")
    public ResponseEntity sendMany() {
        for (int i = 0; i < 10; i++) {
            rabbitSender1.send(i);
//            rabbitSender2.send(i);
        }
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/simple/send/direct")
    public ResponseEntity sendDirect() {

        for (int i = 0; i < 10; i++) {
            directSender.sendMessage("message" + i);
        }
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/simple/send/fanout")
    public ResponseEntity sendFanout() {
        fanoutSender.sendA("aaaaaa");
        fanoutSender.sendB("bbbbbb");
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/simple/send/topic")
    public ResponseEntity sendTopic() {
        topicMessageSender.sendMessage("aaa");
        topicMessageSender.sendMessage2("bbb");
        topicMessageSender.sendMessage3("ccc");
        return ResponseEntity.ok("ok");
    }


}
