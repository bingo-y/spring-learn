package com.bingo.statemachine.state;

/**
 * @Author: tyx
 * @Date: create in 2018/7/26 17:18
 * @Description:
 */
public enum States {
    UNPAID,                 // 待支付
    WAITING_FOR_RECEIVE,    // 待收货
    DONE                    // 结束
}
