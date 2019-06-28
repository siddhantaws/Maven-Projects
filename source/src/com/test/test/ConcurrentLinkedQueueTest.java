package com.test.test;

import com.test.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {
	static ConcurrentLinkedQueue<String > deque =new ConcurrentLinkedQueue<>();
	
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					deque.offer("A");
					deque.offer("B");
					deque.offer("C");
					deque.offer("D");
					deque.offer("E");
					deque.poll();
					deque.poll();
					deque.poll();
					deque.poll();
					deque.poll();
					deque.poll();
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					deque.offer("D");
					deque.offer("E");
					deque.offer("F");
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t2.start();
	}
}
