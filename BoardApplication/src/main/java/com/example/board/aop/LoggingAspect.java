package com.example.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("@annotation(com.example.board.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("AOP 실행 시작: " + joinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); // 실제 메서드 실행
        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " 실행시간 : " + executionTime + "ms");
        return proceed;
    }
}
