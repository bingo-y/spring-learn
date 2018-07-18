package com.bingo.chapter42.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name, password) VALUES(#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})")
    void save(@Param("name") String name, @Param("password") String password);

}
