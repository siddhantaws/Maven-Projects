package com.manh.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class GreetingServiceIntroduction {

    @DeclareParents(
		value = "com.javapassion.examples.GreetingServiceImpl",  	// target class
        defaultImpl = ReverseNameServiceImpl.class					// new implementation
    )		      
    public ReverseNameService reverseNameService;					// new interface

    @DeclareParents(
        value = "com.javapassion.examples.GreetingServiceImpl",  	// target class
        defaultImpl = ReverseMessageServiceImpl.class				// new implementation
    )		      
    public ReverseMessageService reverseMessageService;			  	// new interface
}