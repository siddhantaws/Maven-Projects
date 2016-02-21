package com.manh.executors;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.manh.concurent.ExecutorService;
import com.manh.concurent.Executors;

public class Main {
	
	public static void main(String[] args) 
	{
		ExecutorService service=Executors.newCachedThreadPool();
		
		for(int i=0;i<5;i++)
		{
			service.execute(new Runnable() {
				@Override
				public void run() 
				{
					for(int i=0;i<3;i++)
					{
						System.out.println(1);
						if(i==2)
							throw new RuntimeException();
					}
				}
			});
		}
		
		service.shutdownNow();
		System.out.println((1 << Integer.SIZE-3));
	}
}
