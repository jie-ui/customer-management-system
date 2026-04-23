package com.jieyang.customermanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = LoggerFactory.getLogger(getClass().getName());

    @Pointcut("execution(* com.jieyang.customermanagement.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.jieyang.customermanagement.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.jieyang.customermanagement.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String theMethodName = joinPoint.getSignature().getName();
        myLogger.info("====> in @Before method: " + theMethodName);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info("====> arg: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {

        String theMethodName = joinPoint.getSignature().getName();
        myLogger.info("====> in @AfterReturning: " + theMethodName);

        myLogger.info("====> result: " + returnValue);
    }
}