package com.backend.Advice;

import com.backend.utils.LoggingAdviceUtil;
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
public class ControllerAdvice {

    @Pointcut("execution (* com.backend.controller..*(..))")
    public void controllerPointcut() {}

    @Around("controllerPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.记录方法开始的时间
        long startTime = System.currentTimeMillis();
        // 2.得到MethodSignature类型的方法签名，既可以得到方法的名称，又可以得到方法参数的列表
        //   如果只是使用Signature的话只能得到方法名称
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Map<String, String> baseMap = LoggingAdviceUtil.getBase(joinPoint, signature);
        log.info("【接口调用】:{}.{}",baseMap.get("className"),baseMap.get("methodName"));
        log.info("【请求参数】:{}",baseMap.get("params"));

        // 6.返回结果与耗时,当出现异常时会被全局自定义异常GlobalException捕获
        Object result = null;
        result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long spendTime = endTime - startTime;
        log.info("【请求返回结果】:{}",result);
        log.info("【耗时】:{}",spendTime);
        return result;
    }
}



//// 3.class名字是Controller的名字
////        String className = joinPoint.getTarget().getClass().getName(); // 得到的是包的全类名比如java.lang.String
////        System.out.println("getName()"+className);
//String classSimpleName = joinPoint.getTarget().getClass().getSimpleName(); // 得到的是仅是类的名称
//        System.out.println("getSimpleName()"+classSimpleName);
//// 4.获取方法的名字
//String methodName = signature.getMethod().getName();
//
//// 5.获取方法的参数列表
//Object[] parameterTypes = signature.getParameterTypes(); // 获取参数的类型比如:String name,这个String就是类型
//Object[] parameterNames = signature.getParameterNames(); // 获取参数的名称比如:String name，这个获取的就是name这个名称
//Object[] parameterValues = joinPoint.getArgs(); // 获取参数的值比如:String name = "张三",获取的就是"张三"
//// 将获取到的参数信息组合在一起
//StringBuilder sb = new StringBuilder();
//        for(int i=0; i<parameterNames.length; i++) {
//        sb.append(parameterTypes[i].toString()).append(" ")
//                    .append(parameterNames[i].toString()).append("=")
//                    .append(parameterValues[i].toString());
//        if(i!=parameterNames.length-1) sb.append(",");
//        }















