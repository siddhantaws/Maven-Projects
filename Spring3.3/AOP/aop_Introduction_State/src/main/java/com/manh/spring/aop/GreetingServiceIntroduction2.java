package com.manh.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class GreetingServiceIntroduction2 {

    @DeclareParents( value = "com.javapassion.examples.GreetingServiceImpl",  	// target class
        defaultImpl = CounterServiceImpl.class		      			// new implementation
    )
    public CounterService counter;						  			// new interface
}