package com.manh.springrecipes.vehicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		AccountDao accountDao=context.getBean("accountDao",AccountDao.class);
		/*accountDao.insert(new Account("101", 1000));
		accountDao.insert(new Account("102", 2000));
		accountDao.insert(new Account("104", 4000));
		accountDao.delete(new Account("101", 1000));
		accountDao.update(new Account("102", 5000));*/
	}
}
