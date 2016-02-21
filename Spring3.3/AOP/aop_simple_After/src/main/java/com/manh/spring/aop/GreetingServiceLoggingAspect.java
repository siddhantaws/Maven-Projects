package com.manh.spring.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

	@AfterReturning("execution(String GreetingService.sayHello(..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("AfterReturning: " + nameOfMethod + " gets called with " + arguments);
	}

	@AfterThrowing("execution(* GreetingService.sayHello2(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("AfterThrowing: " + nameOfMethod + " gets called with " + arguments);
	}
}