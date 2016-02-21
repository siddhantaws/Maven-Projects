package com.manh.java7.concurrency.chapter4.recipe12.task;

import java.util.concurrent.Callable;

public class MyExecutiableTask implements  Callable<String> {

	private String name;
	public MyExecutiableTask(String name)
	{
		this.name=name;
	}
	@Override
	public String call() throws Exception 
	{
		Thread.currentThread().sleep(1000);
		return name;
	}


}
