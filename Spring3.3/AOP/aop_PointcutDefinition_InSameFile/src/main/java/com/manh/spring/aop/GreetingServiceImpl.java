package com.manh.spring.aop;

public class GreetingServiceImpl implements GreetingService {

	public String sayHello(String name, String greetingWords) {
		String greeting = greetingWords + " " + name;
		System.out.println(greeting);
		
		return greeting;
	}
	
	public void speakSomething(String something) {
        System.out.println(something);
    }
}