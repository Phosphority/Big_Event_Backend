package com.backend.exception;

import com.backend.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result globalException(Exception ex){
        log.error("【异常】:{}",ex.getMessage());
        return Result.error("操作错误");
    }
}
