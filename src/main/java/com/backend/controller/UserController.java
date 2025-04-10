package com.backend.controller;

import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import com.backend.utils.BCryptUtil;
import com.backend.utils.JwtUtil;
import com.backend.utils.Md5Util;
import com.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

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
        if (userService.findByName(username) != null) {
            return Result.error("注册失败，用户名重复");
        }
        // 2.对插入的密码使用BCrypt进行加密操作
        // 3.对该用户名进行注册,并判断是否注册成功
        if(userService.register(username, Md5Util.getMD5String(password))) {
            return Result.success();
        }
        return Result.error("注册失败");
    }


    // 1.login需要向浏览器返回验证用户是否登录的token，并将token存在header的
    // 2.使用token是基于JWT的验证，所以需要先使用JWT生成token，再返回
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        // 1.先对用户名是否存在进行判断
        User user = userService.findByName(username);
        if (user == null) {
            return Result.error("用户名或密码错误");
        }
        // 2.之后再进行密码是否正确地判断，若登录成功则向前端返回token
        if(Md5Util.checkPassword(password,user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", username);
            String token = JwtUtil.getToken(claims);
            return Result.success(token);
        }
        return Result.error("登录失败");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo() {

        User user = userService.userInfo();
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@Validated @RequestBody User user) {

        if(userService.update(user)){
            return Result.success("更新成功");
        }
        return Result.error("更新失败");
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@Validated @RequestParam String userPic) {

        if(userService.updateAvatar(userPic)){
            return Result.success("更新成功");
        }
        return Result.error("更新失败");
    }


    @PatchMapping("/updatePwd")
    public Result updatePassword(@RequestBody Map<String,String> pwds) {

        Map<String,Object> claims = ThreadLocalUtil.get();
        User user = userService.findByName(claims.get("username").toString());

        if(!(Md5Util.checkPassword(pwds.get("old_pwd"),user.getPassword()))) {
            return Result.error("密码错误");
        }else if(!(pwds.get("new_pwd").equals(pwds.get("re_pwd")))){
            return Result.error("两次密码不一致");
        }else if(userService.updatePassword(pwds.get("re_pwd"))){
            return Result.success();
        }
        return Result.error("更新失败");
    }


}









