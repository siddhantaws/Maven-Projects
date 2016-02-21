package com.manh.spring3.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class SecurityService 
{
	@Pointcut(value="execution(* com.manh.spring3.aop.*Impl.m*(..))")
	public void manh(){}
	@Before(value="manh()")
	public void loginBefore()
	{
		System.out.println("SecurityService->loginBefore");
	}
	@After(value="manh()")
	public void loginAfter()
	{
		System.out.println("SecurityService->loginAfter");
	}
	@AfterReturning(value="manh()")
	public void loginAfterReturning()
	{
		System.out.println("SecurityService->loginAfterReturning");
	}
	@AfterThrowing(value="manh()")
	public void loginAfterThrowing()
	{
		System.out.println("SecurityService->loginAfterThrowing");
	}
}
