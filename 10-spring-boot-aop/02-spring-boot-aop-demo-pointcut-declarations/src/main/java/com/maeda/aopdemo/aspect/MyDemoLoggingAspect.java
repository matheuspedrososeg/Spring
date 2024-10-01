package com.maeda.aopdemo.aspect;

import com.maeda.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.maeda.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====>>> Executing @Before advice on any method from DAO package.");

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + ms);

        Object[] args = joinPoint.getArgs();

        for (Object temparg : args) {

            if (temparg instanceof Account) {
                //downcast and print account
                Account account = (Account) temparg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            } else {
                System.out.println(temparg);
            }
        }
    }
    @AfterReturning(pointcut = "execution(* com.maeda.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningAccountAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @AfterReturning on method: " + method);

        System.out.println("\n===>> Result is " + result);

        // convert account names to upper case
        convertAccountNamesToUpperCase(result);

        System.out.println("\n===>> Result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {

            String uppername = account.getName().toUpperCase();

            account.setName(uppername);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.maeda.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n===>> Exception: " + exc);
    }

    @After("execution(* com.maeda.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @After on method: " + method);
    }

    @Around("execution(* com.maeda.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - start;
        System.out.println("Duration: " + duration + "ms");

        return result;
    }


}
