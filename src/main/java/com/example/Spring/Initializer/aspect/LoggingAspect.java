package com.example.Spring.Initializer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut: Sare methods jo PaymentService class me hain
    @Pointcut("execution(* com.example.aopdemo.service.PaymentService.*(..))")
    public void paymentMethods() {}

    // Before Advice: Method call hone se pehle chalega
    @Before("paymentMethods()")
    public void beforePayment() {
        System.out.println("Logging BEFORE payment method execution...");
    }

    // After Advice: Method execution ke baad chalega
    @After("paymentMethods()")
    public void afterPayment() {
        System.out.println("Logging AFTER payment method execution...");
    }

    // After Returning Advice: Jab method successfully execute ho jaye tab chalega
    @AfterReturning(pointcut = "paymentMethods()", returning = "result")
    public void afterReturningPayment(Object result) {
        System.out.println("Logging AFTER RETURNING: " + result);
    }

    // Around Advice: Method ke pehle aur baad dono chalega
    @Around("paymentMethods()")
    public Object aroundPayment(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around BEFORE method execution...");
        Object result = joinPoint.proceed();  // Actual method call
        System.out.println("Around AFTER method execution...");
        return result;
    }
}
