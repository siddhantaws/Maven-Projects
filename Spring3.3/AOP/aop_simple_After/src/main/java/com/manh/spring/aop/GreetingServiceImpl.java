package com.manh.spring.aop;

public class GreetingServiceImpl implements GreetingService {

//	This method returns successfully
	public String sayHello(String name, String greetingWords) {
		String greeting = greetingWords + " " + name;
		System.out.println(greeting);
		
		return greeting;
	}

//	This method throws an exception
	public String sayHello2(String name, String greetingWords) {
		String greeting = greetingWords + " " + name;
		System.out.println(greeting);
		throw new IllegalArgumentException();
	}
}