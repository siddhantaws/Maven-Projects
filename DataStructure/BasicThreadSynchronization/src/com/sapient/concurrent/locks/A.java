package com.sapient.concurrent.locks;

public class A implements Runnable
{
	private Semaphore semaphore;
	
	public A(Semaphore semaphore)
	{
		this.semaphore=semaphore;
	}
	
	@Override
	public void run() 
	{
		try {
			System.out.println(1);
				semaphore.acquire();
				System.out.println(1);
				semaphore.release();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}		
	}
}
