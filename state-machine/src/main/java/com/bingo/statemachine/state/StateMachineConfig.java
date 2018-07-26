package com.bingo.statemachine.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @Author: tyx
 * @Date: create in 2018/7/26 17:20
 * @Description:
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Event> {

    private static final Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Event> config) throws Exception {
//        config.withConfiguration()
//                .listener(listener());
//    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Event> states) throws Exception {
        states.withStates()
                .initial(States.UNPAID)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Event> transitions) throws Exception {
        transitions.withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Event.PAY)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Event.RECEIVE);
    }

    @Bean
    public StateMachineListener listener() {
        return new StateMachineListenerAdapter<States, Event> () {
            @Override
            public void transition(Transition<States, Event> transition) {
                if (transition.getTarget().getId() == States.UNPAID) {
                    logger.info("订单创建，待支付");
                } else if (transition.getSource().getId() == States.UNPAID
                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
                    logger.info("用户完成支付，待收货");
                } else if (transition.getSource().getId() == States.WAITING_FOR_RECEIVE
                        && transition.getTarget().getId() == States.DONE) {
                    logger.info("用户已收货，订单完成");
                }
            }
        };
    }
}
