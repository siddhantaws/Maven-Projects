package com.sapient.concurrent.locks;

public class Main 
{
	public static void main(String[] args) 
	{
		Semaphore semaphore=new Semaphore(-1);
		
		for(int i=0;i<5;i++)
		{
			Thread t1=new Thread(new A(semaphore));
			t1.start();
		}
		
	}
}
