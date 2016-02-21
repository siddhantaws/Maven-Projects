package com.manh.spring.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)	//Specify order
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

	@Before("execution(* GreetingService.sayHello(..))")
	public void logBefore(JoinPoint joinPoint) {
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("Before1: " + nameOfMethod + " gets called with " + arguments);
	}
}