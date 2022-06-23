package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
//@Service
//@Aspect
public class AroundAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
//
//	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] 비즈니스 메소드 수행 전 처리할 내용");
		Object returnObj = pjp.proceed(); // 비즈니스 메소드 호출
		System.out.println("[AFTER] 비즈니스 메소드 수행 후 처리할 내용");
		return returnObj;
	}
	
}
