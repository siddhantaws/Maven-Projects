package com.manh.java7.concurrency.chapter4.recipe12.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
	public static void main(String[] args) 
	{
		MyFutureTask futureTask[]=new MyFutureTask[5];
		MyExecutiableTask myExecutiableTask[]=new MyExecutiableTask[5];
		ExecutorService service=(ExecutorService)Executors.newFixedThreadPool(5);
		
		for(int i=0;i<5;i++)
		{
			myExecutiableTask[i]=new MyExecutiableTask("i"+i);
			futureTask[i]=new MyFutureTask(myExecutiableTask[i]);
			service.submit(futureTask[i]);
		}
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<5;i++)
		{
			futureTask[i].cancel(true);
		}
		service.shutdown();
	}
}
