package com.backend.Interceptor;

import com.backend.utils.JwtUtil;
import com.backend.utils.RedisUtil;
import com.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        try{
            if(token != null){
                // 1.先解析token为claims
                Map<String, Object> claims = JwtUtil.parseToken(token);
                String redisToken = redisUtil.get(token);
                // 2.如果存在就说明redis中存储的token与请求上来的token一致
                if(redisToken != null){
                    // 3.然后再放入线程中
                    ThreadLocalUtil.set(claims);
                    return true;
                }else {
                    throw new RuntimeException();
                }
            }else {
                throw new RuntimeException();
            }
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
