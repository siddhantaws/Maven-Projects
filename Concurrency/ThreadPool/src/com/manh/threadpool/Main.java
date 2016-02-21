package com.manh.threadpool;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		ThreadPool threadPool=new ThreadPool(10,20);
		while(true)
		{
			threadPool.execute(new MyTask());
			//Thread.currentThread().sleep(1000);
		}
	}
}
