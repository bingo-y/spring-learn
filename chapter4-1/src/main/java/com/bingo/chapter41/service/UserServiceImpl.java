package com.bingo.chapter41.service;

import com.bingo.chapter41.domain.User;
import com.bingo.chapter41.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: tyx
 * @Date: create in 2018/7/18 16:22
 * @Description:
 */
@CacheConfig(cacheNames = "users")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Cacheable(key = "#id")
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void updateUser(Integer id, String name) {
        userMapper.updateUser(id, name);
    }
}
