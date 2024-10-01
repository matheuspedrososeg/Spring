package com.maeda.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution(* com.maeda.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}
    @Pointcut("execution(* com.maeda.aopdemo.dao.*.get*(..))")
    public void gettersPointcut() {}
    @Pointcut("execution(* com.maeda.aopdemo.dao.*.set*(..))")
    public void settersPointcut() {}
    @Pointcut("forDaoPackage() && !(gettersPointcut() || settersPointcut())")
    public void forDaoPackageNoGetterSetter() {}

}
