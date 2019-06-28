package com.test.test;

import com.test.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> queue =new ArrayBlockingQueue<>(2);
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					queue.put("A");	
					queue.put("B");
					queue.put("C");
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
					queue.poll();
				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		t2.start();
	}
}
