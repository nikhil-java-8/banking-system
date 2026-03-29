package com.nikhil.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterReturning("execution(* com.nikhil.service.*.*(..))")
    public void logSuccess(JoinPoint joinPoint) {
        System.out.println("Method Success: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.nikhil.service.*.*(..))", throwing = "ex")
    public void logFailure(JoinPoint joinPoint, Exception ex) {
        System.out.println("Method Failed: " + joinPoint.getSignature().getName()
                + " Error: " + ex.getMessage());
    }
}