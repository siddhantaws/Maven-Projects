package com.manh.spring3.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class LogService 
{

	@Around(value="execution(* com.manh.spring3.aop.*Impl.m*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint)throws Throwable
	{
		System.out.println("The method " + joinPoint.getSignature().getName()+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
		try{
			Object result = joinPoint.proceed();
			System.out.println("The method " + joinPoint.getSignature().getName()+ "() ends with " + result);
			return ((String)result+1);
		}catch(Exception exception)
		{
			System.out.println(Arrays.toString(joinPoint.getArgs()) + " in "+ joinPoint.getSignature().getName() + "()");
			throw exception; 
		}
		
	}
}
