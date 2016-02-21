package com.manh.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class GreetingServicePointcuts {
    
    @Pointcut("execution(* GreetingService.sayHello(..))")
    public void loggingHello(){}
    
    @Pointcut("execution(* GreetingService.say*(..))")
    public void loggingHello2(){}
}