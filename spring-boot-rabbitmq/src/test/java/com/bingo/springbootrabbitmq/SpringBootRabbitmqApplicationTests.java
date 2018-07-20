package com.bingo.springbootrabbitmq;

import com.bingo.springbootrabbitmq.model.User;
import com.bingo.springbootrabbitmq.mq.direct.DirectSender;
import com.bingo.springbootrabbitmq.mq.simple.ObjectSender;
import com.bingo.springbootrabbitmq.mq.simple.StringSender;
import com.bingo.springbootrabbitmq.mq.simple.many.RabbitSender1;
import com.bingo.springbootrabbitmq.mq.simple.many.RabbitSender2;
import com.bingo.springbootrabbitmq.mq.fanout.FanoutSender;
import com.bingo.springbootrabbitmq.mq.topic.TopicMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	StringSender stringSender;

	@Autowired
	ObjectSender objectSender;
	@Autowired
	RabbitSender1 rabbitSender1;
	@Autowired
	RabbitSender2 rabbitSender2;

	@Autowired
	TopicMessageSender topicMessageSender;
	@Autowired
    FanoutSender fanoutSender;

	@Autowired
	DirectSender directSender;

	@Test
	public void rabbitMQStringTest() {
		stringSender.send("hello rabbit");
	}

    @Test
    public void rabbitMQObjectTest() {
        User user = new User("aaa", 18);
        objectSender.send(user);
    }

    @Test
    public void rabbitMQManyTest() {
        for (int i = 0; i < 20; i++) {
            rabbitSender1.send(i);
            rabbitSender2.send(i);
        }
    }

    @Test
    public void rabbitMQTopicTest() {
        topicMessageSender.sendMessage("aaa");
        topicMessageSender.sendMessage2("bbb");
        topicMessageSender.sendMessage3("ccc");
    }

    @Test
    public void rabbitMQFanoutTest() {
        fanoutSender.sendA("aaaaaa");
        fanoutSender.sendB("bbbbbb");
    }

    @Test
    public void rabbitMQDirectTest() {
        for (int i = 0; i < 20; i++) {
            directSender.sendMessage("message" + i);
        }
    }

}
