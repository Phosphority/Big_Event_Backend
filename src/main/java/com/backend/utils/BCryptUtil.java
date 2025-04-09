package com.backend.utils;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    public static String encrypt(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt()); // 对密码进行加密
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword); // 校验密码
    }
}
