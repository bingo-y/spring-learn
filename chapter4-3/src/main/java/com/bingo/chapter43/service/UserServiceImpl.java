package com.bingo.chapter43.service;

import com.bingo.chapter43.domain.User;
import com.bingo.chapter43.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
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
    @Cacheable(value = "userCache", key = "#id")
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    @CachePut(value = "userCache", key = "#id")
    public User updateUser(Integer id, String name) {
        User user = userMapper.findById(id);
        userMapper.updateUser(id, name);
        user.setName(name);
        return user;
    }
}
