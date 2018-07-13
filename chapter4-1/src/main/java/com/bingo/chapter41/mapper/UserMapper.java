package com.bingo.chapter41.mapper;

import com.bingo.chapter41.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @Author: tyx
 * @Date: create in 2018/6/29 17:09
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone")
    })
    @Select("select name, phone from user where name = #{name}")
    User findByName(@Param("name") String n);

    @Insert("INSERT INTO USER(name, phone) VALUES(#{name,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR})")
    void insertUser(Map<String, Object> map);

}
