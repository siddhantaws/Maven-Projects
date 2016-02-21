package com.manh.springrecipes.shop;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Cashier  cashier= context.getBean("Cashier",Cashier.class);
		cashier.checkout(new CheckoutEvent(cashier, 1000, new Date()));
    }
      
}