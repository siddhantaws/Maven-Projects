package com.manh.cdi.javase;

import javax.inject.Named;

@Named("greeting")
public class Greeting 
{
    public String greet(String name){
        return "Hello " + name;
    }
}
