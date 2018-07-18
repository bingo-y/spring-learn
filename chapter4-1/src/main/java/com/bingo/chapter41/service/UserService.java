package com.bingo.chapter41.service;

import com.bingo.chapter41.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: tyx
 * @Date: create in 2018/7/18 16:21
 * @Description:
 */
public interface UserService {

    User findById(Integer id);

    void updateUser(Integer id, String name);

}
