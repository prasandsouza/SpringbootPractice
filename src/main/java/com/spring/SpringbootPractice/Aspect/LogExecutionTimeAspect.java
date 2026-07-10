package com.spring.SpringbootPractice.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {

    @Around("@annotation(com.spring.SpringbootPractice.Annotation.LogExecutionTime)")
    public Object logExecutionTime(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
            return proceed;
        } catch (Throwable throwable) {
            long executionTime = System.currentTimeMillis() - start;
            log.error("{} failed after {} ms", joinPoint.getSignature(), executionTime, throwable);
            throw throwable;
        }
    }
}
