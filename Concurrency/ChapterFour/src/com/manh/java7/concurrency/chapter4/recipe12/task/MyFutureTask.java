package com.manh.java7.concurrency.chapter4.recipe12.task;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import com.manh.java7.concurrency.chapter4.recipe9.task.ExecutableTask;

public class MyFutureTask extends FutureTask<String> 
{	
	private String name;
	
	public MyFutureTask(Callable<String> callable)
	{
		super(callable);
		
	}
	@Override
	protected void done() 
	{
		if(isCancelled())
			System.out.println("task Got Canceled");
		else
			System.out.println("Task Got Completed");
	}
}
