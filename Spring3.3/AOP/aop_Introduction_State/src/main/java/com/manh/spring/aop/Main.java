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
        
//      Cast greetingService object to the ReverseName interface type
        ReverseNameService reverseName = (ReverseNameService) greetingService;
        String rname = reverseName.reverseName(name);
        
//      Cast greetingService object to the ReverseMessage interface type
        ReverseMessageService reverseMessage = (ReverseMessageService) greetingService;
        String rmessage = reverseMessage.reverseMessage(message); 
        
        greetingService.sayHello(rname, rmessage);
        
//      Cast greetingService object to the Counter interface type
        CounterService counterService = (CounterService) greetingService;
        counterService.increase();		// counter is now 1
        counterService.increase();		// counter is now 2
        counterService.increase();		// counter is now 3
        
        System.out.println("counter = " + counterService.getCount());  
    }
}