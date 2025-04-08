package com.backend.service.impl;

import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // 1.首先考虑修改时间与创建时间

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username, String password) {
        return userMapper.findByName(username,password);
    }

    @Override
    public boolean register(String username, String password) {
        return userMapper.register(username,password);
    }
}
