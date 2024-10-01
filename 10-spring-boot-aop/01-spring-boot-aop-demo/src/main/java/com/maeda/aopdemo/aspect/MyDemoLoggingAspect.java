package com.maeda.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* com.maeda.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on any method from DAO package.");
    }
}
