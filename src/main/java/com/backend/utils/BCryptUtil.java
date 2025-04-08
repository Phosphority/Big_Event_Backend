package com.backend.utils;



public class BCryptUtil {
    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encrypt(String password) {
        return encoder.encode(password); // 对密码进行加密
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword); // 校验密码
    }
}
