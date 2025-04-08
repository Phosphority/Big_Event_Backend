package com.backend.mapper;

import com.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User findByName(@Param("username") String username,@Param("password") String password);

    @Insert("insert into user(username, password,create_time, update_time) values(#{username},#{password},now(),now())")
    boolean register(@Param("username") String username,@Param("password") String password);
}
