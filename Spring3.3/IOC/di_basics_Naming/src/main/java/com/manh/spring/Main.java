package com.manh.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
       
        String s1 = (String)factory.getBean("name1");
        String s2 = (String)factory.getBean("name2");
        String s3 = (String)factory.getBean("name3");
        String s4 = (String)factory.getBean("name4");
       
        System.out.println((s1 == s2));
        System.out.println((s2 == s3));
        System.out.println((s3 == s4));
       
        String[] x = factory.getAliases("name3");
        System.out.println("aliases = " + x[0] + " " + x[1] + " " + x[2]);
        
        String s5 = (String)factory.getBean("string1");
        System.out.println("bean string1 = " + s5);
        String s6 = (String)factory.getBean("string2");
        System.out.println("bean string2 = " + s6);
        String s7 = (String)factory.getBean("java.lang.String");
        System.out.println("bean java.lang.String = " + s7);
    }
}