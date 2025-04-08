package com.backend.service;

import com.backend.entity.User;

public interface UserService {
    User findByName(String username, String password);

    boolean register(String username, String password);
}
