package com.manh.spring3.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		HaiService haiService=context.getBean("HaiService", HaiService.class);
		HelloService helloService=context.getBean("HelloService", HelloService.class);
		haiService.m1("1","2");
		//haiService.m2("1","2");
	}
}
