package com.manh.unsafe;

public class Lab2 
{
	public static void main(String[] args) 
	{
		for(int i=0;i<10000000;i++)
		{
			Thread t1=new Thread(new Runnable() {
				
				@Override
				public void run() 
				{
					while(true)
					{
						System.out.println(1);
					}
					
				}
			});
			t1.start();
		}
	}
}
