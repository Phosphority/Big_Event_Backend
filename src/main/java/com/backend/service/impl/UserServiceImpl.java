package com.backend.service.impl;

import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import com.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    // 1.首先考虑修改时间与创建时间

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public boolean register(String username, String password) {
        return userMapper.register(username,password);
    }

    @Override
    public User userInfo() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        return userMapper.userInfo(id);
    }

    @Override
    public boolean update(User user) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        user.setId(id);
        return userMapper.update(user);
    }

    @Override
    public boolean updateAvatar(String userPic) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        return userMapper.updateAvatar(userPic,id);
    }

    @Override
    public boolean updatePassword(String newPwd) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        return userMapper.updatePassword(newPwd,id);
    }
}
