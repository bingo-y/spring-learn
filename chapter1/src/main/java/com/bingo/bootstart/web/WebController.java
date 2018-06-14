package com.bingo.bootstart.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tyx
 * @Date: create in 2018/6/14 16:22
 * @Description:
 */
@RestController
public class WebController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

}
