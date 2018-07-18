package com.bingo.chapter42.service.impl;

import com.bingo.chapter42.mapper.UserMapper;
import com.bingo.chapter42.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(String name, String password) {
        userMapper.save(name, password);
    }
}
