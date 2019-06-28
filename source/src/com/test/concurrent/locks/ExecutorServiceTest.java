package com.test.concurrent.locks;

import com.test.concurrent.Callable;
import com.test.concurrent.ExecutorService;
import com.test.concurrent.Executors;
import com.test.concurrent.Future;

public class ExecutorServiceTest {
	private static ExecutorService service =Executors.newFixedThreadPool(1);
	
	public static void main(String[] args) {
		
		Future<Integer> future =service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				TimeUnit.SECONDS.sleep(1);
				return null;
			}
		});
		
		Future<Integer> future1 =service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				TimeUnit.SECONDS.sleep(1);
				return null;
			}
		});
		Future<Integer> future2 =service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				TimeUnit.SECONDS.sleep(1);
				return null;
			}
		});
	}
}
