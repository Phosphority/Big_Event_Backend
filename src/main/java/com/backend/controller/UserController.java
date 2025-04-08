package com.backend.controller;

import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import com.backend.utils.BCryptUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    // 1.先确定请求类型是post，get，put等
    // 2.请求参数是通过json格式穿上来还是路径的方式传上来
    // 3.确定参数类型以及是否有限制比如email和url的类型

    // 1.第一步先考虑是否要对参数进行判断，然后再开始写业务
    // 2.

    @Resource
    private UserService userService;


    @PostMapping("/register")
    public Result register(@RequestParam String username, @RequestParam String password) {
        // 1.判断数据库当中是否有重复的用户名
        if (userService.findByName(username, password) != null) {
            return Result.error("注册失败，用户名重复");
        }
        // 2.对插入的密码使用BCrypt进行加密操作
        // 3.对该用户名进行注册,并判断是否注册成功
        if(userService.register(username, BCryptUtil.encrypt(password))){
            return Result.success();
        }
        return Result.error("注册失败");
    }

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        // 1.先对用户名是否存在进行判断
        if (userService.findByName(username, password) == null) {
            return Result.error("用户名或密码错误");
        }
        // 2.之后再进行密码是否正确的判断
//        if(userService.login(username,password)){
//
//
//            return Result.success();
//        }
        return Result.error("登录失败");
    }
}









