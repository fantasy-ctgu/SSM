package com.ctgu.ssm.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class testaop {
	@Pointcut("execution(* com.ctgu.ssm.controller.*.*(..))")
	public void testAop() {
	}

	@Before("testAop()")
	public void testAop1() {
		System.out.println(" UserController beforeAdvice ... ");
	}
}
