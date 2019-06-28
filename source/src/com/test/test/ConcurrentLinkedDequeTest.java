package com.test.test;

import com.test.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeTest {
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> deque =new ConcurrentLinkedDeque<>(); 
		 
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					deque.push("A");
					deque.push("B");
					deque.push("C");
					deque.push("D");
					deque.push("E");
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
					deque.push("D");
					deque.push("E");
					deque.push("F");
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t2.start();
	}
}
