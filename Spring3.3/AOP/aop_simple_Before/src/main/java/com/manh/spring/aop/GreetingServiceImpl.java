package com.manh.spring.aop;

public class GreetingServiceImpl implements GreetingService {

	public String sayHello(String name, String greetingWords) {
		String greeting = greetingWords + " " + name;
		System.out.println(greeting);
		
		return greeting;
	}
	public GreetingServiceImpl()
	{
		System.out.println("GreetingServiceImpl()");
	}
}