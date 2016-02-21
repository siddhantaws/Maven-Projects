package com.manh.collection;

import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueMain 
{
	public static void main(String[] args) 
	{
		LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>(2);
		queue.offer("C");
		queue.offer("D");
		try {
			queue.offer("E",2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queue.poll();
	}
}
