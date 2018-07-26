package com.bingo.statemachine;

import com.bingo.statemachine.state.Event;
import com.bingo.statemachine.state.StateMachineConfig;
import com.bingo.statemachine.state.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

	@Autowired
	StateMachine<States, Event> stateMachine;

	@Test
	public void stateMachineTest() {

		stateMachine.start();
		stateMachine.sendEvent(Event.PAY);
		stateMachine.sendEvent(Event.RECEIVE);

	}

}
