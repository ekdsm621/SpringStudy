package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// JoinPoint 객체를 사용

//@Service
//@Aspect
public class BeforeAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
//	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.out.println(sign.getName());
		Object[] args = jp.getArgs();
		System.out.println("메소드 args 정보"+args[0]);
//		System.out.println(sign.toLongString());
//		System.out.println(sign.toShortString());
		System.out.println("[사전처리] 비즈니스 로직 수행 전 동작");
	}
}
