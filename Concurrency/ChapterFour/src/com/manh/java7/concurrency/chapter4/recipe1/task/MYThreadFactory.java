package com.manh.java7.concurrency.chapter4.recipe1.task;

import java.util.concurrent.ThreadFactory;

public class MYThreadFactory implements ThreadFactory 
{
	@Override
	public Thread newThread(Runnable r) 
	{
		return new Thread(r);
	}
	
}
