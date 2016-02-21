package com.manh.spring3.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class LogService 
{

	@Before("execution(* com.manh.spring3.aop.*Impl.m*(..))")
	public void loginBefore(JoinPoint joinPoint)
	{
		System.out.println("LogService->loginBefore");
		System.out.println("joinPoint.getKind()->"+joinPoint.getKind());
		System.out.println("joinPoint.getArgs()->"+Arrays.toString(joinPoint.getArgs()));
		System.out.println("joinPoint.getTarget()->"+joinPoint.getTarget());
		System.out.println("joinPoint.getThis()->"+joinPoint.getThis());
		System.out.println("joinPoint.getSignature()->"+joinPoint.getSignature());
		System.out.println("joinPoint.getSourceLocation()->"+joinPoint.getSourceLocation());
	}
	@After("execution(* com.manh.spring3.aop.*Impl.m*(..))")
	public void loginAfter(JoinPoint joinPoint)
	{
		System.out.println("LogService->loginAfter");
	}
	@AfterReturning(pointcut="execution(* com.manh.spring3.aop.*Impl.m*(..))",returning="result")
	public void loginAfterReturning(JoinPoint joinPoint ,Object result)
	{
		System.out.println("LogService->loginAfterReturning");
		System.out.println("LogService->loginAfterReturning"+result);
	}
	@AfterThrowing(pointcut="execution(* com.manh.spring3.aop.*Impl.m*(..))",throwing="throwable")
	public void loginAfterThrowing(JoinPoint joinPoint,RuntimeException throwable)
	{
		System.out.println("LogService->loginAfterThrowing");
		System.out.println("LogService->"+throwable);
	}
}
