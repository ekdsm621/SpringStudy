package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

// JoinPoint jp: 호출한 비즈니스 메소드에 대한 정보
// Object obj: 바인드변수

// 바인드변수: 비즈니스 메소드가 리턴할 결과값을 바인딩할 목적으로 사용
//			 결과값 타입을 알 수 없기 때문에 Object 타입으로 선언

// applicationContext.xml 에서 returning="returnObj"추가
//@Service
//@Aspect
public class AfterReturningAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void allPointcut() {}
//	
//	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+ "로그인(admin)");
			}
		}
		System.out.println("[사후 처리]"+ method + "() 메소드 리턴값 : "+returnObj.toString());
	}

}
