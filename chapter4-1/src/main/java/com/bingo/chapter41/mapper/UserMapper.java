package com.bingo.chapter41.mapper;

import com.bingo.chapter41.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * @Author: tyx
 * @Date: create in 2018/6/29 17:09
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Update("update user set name = #{name} where id = #{id}")
    void updateUser(@Param("id") Integer id, @Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone")
    })
    @Select("select name, phone from user where name = #{name}")
    User findByName(@Param("name") String n);

    @Insert("INSERT INTO USER(name, phone) VALUES(#{name,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR})")
    void insertUser(Map<String, Object> map);

}
