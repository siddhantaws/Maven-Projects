package com.manh.servlet;

public class InformalGreeting implements GreetingInterface {
    public String greet(String name){
        return "Informal Hello " + name;
    }
}
