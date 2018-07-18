package com.bingo.chapter43.mapper;

import com.bingo.chapter43.domain.User;
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
