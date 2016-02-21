package com.manh.spring.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

//	Declare "loggingHello" pointcut
	@Pointcut("execution(* GreetingService.sayHello(..))")
	private void loggingHello() {}

//	Declare loggingSpeak pointcut
	@Pointcut("execution(* GreetingService.speakSomething(..))")
	private void loggingSpeak() {}
	
//	Use "loggingHello" pointcut declaration in the advice
	@Before("loggingHello()")
	public void logBeforeHello(JoinPoint joinPoint) {
		logBefore(joinPoint);
	}

//	Use "loggingHello" pointcut declaration in the advice
	@AfterReturning("loggingHello()")
	public void logAfterReturningHello(JoinPoint joinPoint) {
		logAfterReturning(joinPoint);
	}
	
//	Use "loggingSpeak" pointcut declaration in the advice
	@Before("loggingSpeak()")
	public void logBeforeSpeak(JoinPoint joinPoint) {
		logBefore(joinPoint);
	}
	
//	Use "loggingSpeak" pointcut declaration in the advice
	@AfterReturning("loggingSpeak()")
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