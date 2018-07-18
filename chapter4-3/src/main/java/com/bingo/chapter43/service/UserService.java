package com.bingo.chapter43.service;


import com.bingo.chapter43.domain.User;

/**
 * @Author: tyx
 * @Date: create in 2018/7/18 16:21
 * @Description:
 */
public interface UserService {

    User findById(Integer id);

    User updateUser(Integer id, String name);

}
