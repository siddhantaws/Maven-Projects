package com.manh.java7.concurrency.chapter2.recipe4.task;

import com.manh.concurrent.locks.Lock;
import com.manh.concurrent.locks.ReentrantLock;





/**
 * This class simulates a print queue
 *
 */
public class PrintQueue {

	/**
	 * Lock to control the access to the queue.
	 */
	private final Lock queueLock=new ReentrantLock(false);
	
	/**
	 * Method that prints a document
	 * @param document document to print
	 */
	public void printJob(Object document)
	{
		System.out.println("enter print Jbo "+Thread.currentThread().getName());
		try {
			queueLock.lock();
			Long duration=(long)(Math.random()*10000);
			//System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),(duration/1000));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally 
		{
			System.out.println("enter print Jbo release Lock "+Thread.currentThread().getName());
			queueLock.unlock();
		}
	}
}
