package com.bingo.chapter2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: tyx
 * @Date: create in 2018/6/15 11:56
 * @Description:
 */
@Data
@ConfigurationProperties
public class Language {

    private String type;

    private int level;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
