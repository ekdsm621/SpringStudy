package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// JoinPoint ��ü�� ���

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
		System.out.println("�޼ҵ� args ����"+args[0]);
//		System.out.println(sign.toLongString());
//		System.out.println(sign.toShortString());
		System.out.println("[����ó��] ����Ͻ� ���� ���� �� ����");
	}
}
