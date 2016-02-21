package com.manh.executors;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.manh.concurent.ExecutorService;
import com.manh.concurent.Executors;

public class Main {
	
	public static void main(String[] args) 
	{
		ExecutorService service=Executors.newFixedThreadPool(1);
		service.execute(new Runnable() {
			
			@Override
			public void run() {
						while(true)
						{
							System.out.println(1);
						}
				
			}
		});
		service.execute(new Runnable() {
			
			@Override
			public void run() {
						while(true)
						{
							System.out.println(2);
						}
				
			}
		});
		//service.shutdownNow();
	}
}
