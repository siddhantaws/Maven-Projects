package com.manh.spring.aop;

import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

//	Whenever GreetingService.sayHello(..) method gets executed, run logBefore(..) advice.
	@Before("execution(* GreetingService.sayHello(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(Calendar.getInstance().getTime());
		
		String nameOfMethod = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("Before: " + nameOfMethod + " gets called with " + arguments);
	}
}