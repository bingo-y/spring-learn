package com.bingo.springbootrabbitmqack.model;

import java.io.Serializable;

/**
 * @Author: tyx
 * @Date: create in 2018/7/23 15:12
 * @Description:
 */
public class User implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
