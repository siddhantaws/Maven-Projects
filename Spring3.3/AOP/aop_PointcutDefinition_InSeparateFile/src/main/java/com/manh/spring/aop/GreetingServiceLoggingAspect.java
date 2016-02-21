package com.manh.spring.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

	@Before("GreetingServicePointcuts.loggingHello()")
	public void logBeforeHello(JoinPoint joinPoint) {
		logBefore(joinPoint);
	}

	@AfterReturning("GreetingServicePointcuts.loggingHello()")
	public void logAfterReturningHello(JoinPoint joinPoint) {
		logAfterReturning(joinPoint);
	}
	
	@Before("GreetingServicePointcuts.loggingSpeak()")
	public void logBeforeSpeak(JoinPoint joinPoint) {
		logBefore(joinPoint);
	}
	
	@AfterReturning("GreetingServicePointcuts.loggingSpeak()")
	public void logAfterReturningSpeak(JoinPoint joinPoint) {
		logAfterReturning(joinPoint);
	}
	
	private void logBefore(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("Before1: " + nameOfMethod + " gets called with " + arguments);
	}
	
	private void logAfterReturning(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("AfterReturning1: " + nameOfMethod + " gets called with " + arguments);
	}
}