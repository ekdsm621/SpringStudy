package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
//@Service
//@Aspect
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
//	
//	@AfterThrowing(pointcut="allPointcut()",throwing="exception")
	public void exceptionLog(JoinPoint jp, Exception exception) {
		String method = jp.getSignature().getName(); // JoinPoint
		String msg = exception.getMessage();
		System.out.println(method+"() 수행 중 발생된 예외 메세지: "+msg);
		System.out.println("[예외처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
