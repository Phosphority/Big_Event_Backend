package com.backend.exception;

import com.backend.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result globalException(Exception ex){
        System.out.println("系统异常: "+ex.getMessage());
        return Result.error("操作错误");
    }
}
