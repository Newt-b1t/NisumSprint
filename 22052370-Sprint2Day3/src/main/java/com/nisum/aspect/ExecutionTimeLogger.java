package com.nisum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeLogger {

    @Before("execution(* com.nisum.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP LOG] About to execute method: " + joinPoint.getSignature().getName());
    }
}