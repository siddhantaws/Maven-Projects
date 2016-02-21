package com.manh.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	GreetingService greeting = (GreetingService) context.getBean("greetingService");
        greeting.sayHello("Sang Shin", "Good morning!");
        
        context.close();
    }
}