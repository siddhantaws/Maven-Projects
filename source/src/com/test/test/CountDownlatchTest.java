package com.test.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.concurrent.CountDownLatch;

public class CountDownlatchTest {
	static CountDownLatch latch = new CountDownLatch(3);

	public static void main(String[] args) {
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));
		cacheService.start(); 
		alertService.start();
		validationService.start();
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					latch.await();
				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					latch.await();
				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		t2.start();

		try {
			latch.await(); // main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	static class Service implements Runnable {
		private final String name;
		private final int timeToStart;
		private final CountDownLatch latch;

		public Service(String name, int timeToStart, CountDownLatch latch) {
			this.name = name;
			this.timeToStart = timeToStart;
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(timeToStart);
			} catch (InterruptedException ex) {
				Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println(name + " is Up");
			latch.countDown(); // reduce count of CountDownLatch by 1
		}

	}

}
