package com.test.test;

import com.test.concurrent.ExecutorService;
import com.test.concurrent.Executors;

public class ExecutorServiceTest {
	
	public static void main(String[] args) {
		ExecutorService service =Executors.newFixedThreadPool(1);
		
		Thread t1 =new Thread(()-> {
			service.submit(()->{System.out.println(1);});
		});
		t1.start();
		Thread t2 =new Thread(()-> {
			service.submit(()->{System.out.println(1);});
		});
		t2.start();
	}
}
