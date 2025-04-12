package com.backend.Advice;

import com.backend.utils.LoggingAdviceUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
@Slf4j
public class ServiceAdvice {

    @Pointcut("execution(* com.backend.service.impl..*(..))")
    public void servicePointcut() {}

    @Around("servicePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Map<String, String> baseMap = LoggingAdviceUtil.getBase(joinPoint, signature);
        log.info("【方法接口】:{}.{}",baseMap.get("className"),baseMap.get("methodName"));
        log.info("【方法参数】:{}",baseMap.get("params"));

        Object result = null;
        result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        log.info("【业务返回结果】:{}",result);
        log.info("【耗时】:{}",totalTime);
        return result;
    }
}

//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = signature.getMethod().getName();
//
//        Object[] parameterTypes = signature.getParameterTypes();
//        Object[] parameterNames = signature.getParameterNames();
//        Object[] parameterValues = joinPoint.getArgs();
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < parameterNames.length; i++) {
//            sb.append(parameterTypes[i].toString()).append(" ")
//                    .append(parameterNames[i].toString()).append("=")
//                    .append(parameterValues[i].toString());
//            if(i != parameterNames.length-1) sb.append(",");













