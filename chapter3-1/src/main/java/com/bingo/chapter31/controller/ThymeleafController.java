package com.bingo.chapter31.controller;

import com.bingo.chapter31.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: tyx
 * @Date: create in 2018/6/28 16:50
 * @Description:
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("host", "http://www.bingoy.top/");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("json错误");
    }

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

}
