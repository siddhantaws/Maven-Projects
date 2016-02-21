package com.manh.wmos;

import com.manh.concurrent.ArrayBlockingQueue;

public class ArrayMain 
{
	public static void main(String[] args) 
	{
		final ArrayBlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue<>(1);
		
		for(int i=0;i<3;i++)
		{
			Thread t1=new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						arrayBlockingQueue.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t1.start();
		}
		
		for(int i=0;i<3 ;i++)
		{
			Thread t1=new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						arrayBlockingQueue.put("A");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t1.start();
		}
		
		
	}
}
