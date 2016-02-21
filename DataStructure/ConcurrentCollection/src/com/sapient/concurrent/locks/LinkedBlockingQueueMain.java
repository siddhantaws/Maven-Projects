package com.sapient.concurrent.locks;

public class LinkedBlockingQueueMain 
{
	public static void main(String[] args) 
	{
		LinkedBlockingQueue<String> blockingQueue=new LinkedBlockingQueue<>(2);
		for(int i=0;i<2;i++)
		{
			Producer p1=new Producer(blockingQueue);
			Thread t1=new Thread(p1);
			t1.start();
		}
		Consumer  p1=new Consumer(blockingQueue);
		Thread t1=new Thread(p1);
		t1.start();
	}
	
}
class Producer implements Runnable
{
	private LinkedBlockingQueue<String> blockingQueue;
	
	public Producer(LinkedBlockingQueue<String> blockingQueue)
	{
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() 
	{
		try {
			blockingQueue.put("A");
			blockingQueue.put("B");
			blockingQueue.put("C");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class Consumer implements Runnable
{
	private LinkedBlockingQueue<String> blockingQueue;
	
	public Consumer(LinkedBlockingQueue<String> blockingQueue)
	{
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() 
	{
			System.out.println(1);
			blockingQueue.poll();
	}
}