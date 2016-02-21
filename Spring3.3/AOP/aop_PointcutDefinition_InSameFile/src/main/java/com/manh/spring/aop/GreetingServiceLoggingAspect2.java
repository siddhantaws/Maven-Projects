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
@Order(2)
public class GreetingServiceLoggingAspect2 {

	private Log log = LogFactory.getLog(this.getClass());

	@Pointcut("execution(* GreetingService.say*(..))")
	private void loggingHello2() {}

	@Before("loggingHello2()")
	public void logBefore(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("Before2: " + nameOfMethod + " gets called with " + arguments);
	}

	@AfterReturning("loggingHello2()")
	public void logAfterReturning(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("AfterReturning2: " + nameOfMethod + " gets called with " + arguments);
	}
}