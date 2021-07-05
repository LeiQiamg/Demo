package com.hello.demo.config;

import com.hello.demo.entity.dto.ResultBody;
import com.hello.demo.entity.dto.User;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面配置
 * @author leiqiang
 * @date 2021/4/23
 */
//@Aspect
//@Component
public class AopConfig {

    @Pointcut("execution(public * com.hello.demo.controller.*.*(..  ))")
    public void doOperation() {

    }

    /**
     * 切面前置通知
     * @param joinPoint
     */
    @Before("doOperation()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        //获取链接点参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            User user = (User) arg;
            System.out.println("前置通知参数:" + user);
            String password = base64DeStr(user.getPassword());
            user.setPassword(password);
        }
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("doOperation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知方法执行前目标方法名:" + proceedingJoinPoint.getSignature().getName());
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕通知方法执行后通知");
        return proceed;
    }

    /**
     * 切面后置通知
     */
    @AfterReturning(returning = "object", pointcut = "doOperation()")
    public void doAfterReturning(Object object) throws UnsupportedEncodingException {
        ResultBody resultBody = (ResultBody) object;
        List<User> result = (ArrayList<User>) resultBody.getResult();
        for (User user : result) {
            user.setPassword(base64EnStr(user.getPassword().toString()));
        }
        System.out.println("后置通知返回参数:" + result);
        resultBody.setResult(result);
    }

    /**
     * 加密
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public String base64EnStr(String str) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
    }

    /**
     * 解密
     * @param encodeStr
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64DeStr(String encodeStr) throws UnsupportedEncodingException {
        byte[] decodeStr = Base64.getDecoder().decode(encodeStr);
        return new String(decodeStr, "UTF-8");
    }

}
