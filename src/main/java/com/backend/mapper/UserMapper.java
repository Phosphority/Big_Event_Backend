package com.backend.mapper;

import com.backend.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findByName(@Param("username") String username);

    @Insert("insert into user(username, password,create_time, update_time) values(#{username},#{password},now(),now())")
    boolean register(@Param("username") String username,@Param("password") String password);

    @Select("select * from user where id = #{id}")
    User userInfo(Integer id);

    @Update("update user " +
            "set username = #{username},nickname = #{nickname},email = #{email},update_time = now()" +
            "where id = #{id}")
    boolean update(User user);

    @Update("update user " +
            "set user_pic = #{userPic},update_time = now()" +
            "where id = #{id}")
    boolean updateAvatar(@Param("userPic") String userPic,@Param("id") Integer id);

    @Update("update user set password = #{newPwd},update_time = now() where id = #{id}")
    boolean updatePassword(@Param("newPwd")String newPwd, @Param("id") Integer id);
}
