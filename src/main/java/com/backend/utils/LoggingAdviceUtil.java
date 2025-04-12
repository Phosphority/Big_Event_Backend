package com.backend.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;
import java.util.Map;

public class LoggingAdviceUtil {

    public static Map<String,String> getBase(ProceedingJoinPoint joinPoint, MethodSignature signature){
        Map<String, String> map = new HashMap<>();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = signature.getMethod().getName();
        map.put("className", className);
        map.put("methodName", methodName);

        Object[] parameterTypes = signature.getParameterTypes();
        Object[] parameterNames = signature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterTypes[i].toString()).append(" ")
                    .append(parameterNames[i].toString()).append("=")
                    .append(parameterValues[i].toString());
            if(i != parameterNames.length-1) sb.append(",");
        }
        map.put("params", sb.toString());
        return map;
    }
}
