package com.bingo.statemachine.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Author: tyx
 * @Date: create in 2018/7/26 17:42
 * @Description:
 */
@WithStateMachine
public class EventConfig {

    private static final Logger logger = LoggerFactory.getLogger(EventConfig.class);

    @OnTransition(target = "UNPAID")
    public void start() {
        logger.info("订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        logger.info("用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        logger.info("用户已收货，订单完成");
    }

}
