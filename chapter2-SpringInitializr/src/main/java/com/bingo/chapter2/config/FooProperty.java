package com.bingo.chapter2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: tyx
 * @Date: create in 2018/6/15 11:35
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "com.foo")
public class FooProperty {

    private String company;

    private String location;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
