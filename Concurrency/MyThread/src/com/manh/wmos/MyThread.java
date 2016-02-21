package com.manh.wmos;

public class MyThread 
{
	public static void main(String[] args) 
	{
		Thread t1=new Thread(new Producer(),"Thread1");
		t1.setPriority(8);
		t1.start();
		t1.start();
		
	}
	static class Producer implements Runnable
	{

		@Override
		public void run() 
		{
			for(int i=0;i<2;i++)
			{
				if(i==10000)
				{
					System.out.println("Yeild Called for Thread :"+Thread.currentThread().getName());
					Thread.currentThread().yield();
				}
				System.out.println(Thread.currentThread().getName());	
			}
		}
		
	}
}
