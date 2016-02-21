package com.manh.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		GreetingService greetingService = (GreetingService) context.getBean("greetingService");

		context.close();
		
		String name 	= "Sang Shin";
		String message 	= "Good morning!";
		
		greetingService.sayHello(name, message);

//		Cast greeting object to the ReverseName interface type
		ReverseNameService reverseName = (ReverseNameService) greetingService;
		String rname = reverseName.reverseName(name);

//		Cast greeting object to the ReverseMessage interface type
		ReverseMessageService reverseMessage = (ReverseMessageService) greetingService;
		String rmessage = reverseMessage.reverseMessage(message);

		greetingService.sayHello(rname, rmessage);
	}
}