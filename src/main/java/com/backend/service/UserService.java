package com.backend.service;

import com.backend.entity.User;

public interface UserService {
    User findByName(String username);

    boolean register(String username, String password);

    User userInfo();

    boolean update(User user);

    boolean updateAvatar(String userPic);

    boolean updatePassword(String newPwd);
}
