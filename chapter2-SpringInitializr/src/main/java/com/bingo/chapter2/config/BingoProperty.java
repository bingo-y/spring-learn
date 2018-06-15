package com.bingo.chapter2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: tyx
 * @Date: create in 2018/6/15 10:54
 * @Description:
 */
@Component
public class BingoProperty {

    @Value("${com.bingo.name}")
    private String name;

    @Value("${com.bingo.title}")
    private String title;

    @Value("${com.bingo.value}")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
