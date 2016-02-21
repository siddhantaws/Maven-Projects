package com.manh.spring.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.joda.time.DateTime;

@Aspect
public class GreetingServiceLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

//	Around aspect for all method invocations
	@Around("execution(* *.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info(
			"The method " + joinPoint.getSignature().getName() + 
			"() begins with " + Arrays.toString(joinPoint.getArgs())
		);
		try {
			Object result = joinPoint.proceed();
			log.info(
				"The method " + joinPoint.getSignature().getName() + 
				"() ends with " + result
			);
			
//			Modify greeting according to the day time
			DateTime now = new DateTime();
			DateTime noon = new DateTime(
				now.getYear(), 
				now.getMonthOfYear(), 
				now.getDayOfMonth(), 
				12, 
				0
			);
			if(!now.isBefore(noon)) {
				result = ((String) result).replace("morning", "afternoon");
			}
				
			return result;
		} catch (IllegalArgumentException e) {
			log.error(
				"Illegal argument " + Arrays.toString(joinPoint.getArgs()) + 
				" in " + joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
}