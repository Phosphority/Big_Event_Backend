package com.backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    // 1.创建一个token通常由三部分组成
    // 2.一个是解析以及token编码的密钥Key
    // 3.然后是分别是创建和解析token方法
    // 4.我们可以在token中存入一些在请求中会重复使用的数据
    // 5.token还需要设置生效的时间

    private final static String Key = "phosphophyllite";

    public static String getToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .sign(Algorithm.HMAC256(Key));
    }

    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(Key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
