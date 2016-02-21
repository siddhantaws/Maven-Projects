package com.manh.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        Person person = (Person)factory.getBean("person");
        System.out.println(getPersonInfo(person));
    }
      
    public static String getPersonInfo(Person person) {
        return    "Name:" + person.getName() + "\n"
                + "Age:" + person.getAge() + "\n"
                + "Height: " + person.getHeight() + "\n"
                + "Is Programmer?: " + person.getIsProgrammer();
    }
}