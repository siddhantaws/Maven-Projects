package com.manh.java7.concurrency.chapter2.recipe5.core;

import com.manh.java7.concurrency.chapter2.recipe5.task.PricesInfo;
import com.manh.java7.concurrency.chapter2.recipe5.task.Reader;
import com.manh.java7.concurrency.chapter2.recipe5.task.Writer;

/**
 * Main class of the example
 *
 */
public class Main {

	/**
	 * Main class of the example
	 * @param args
	 */
	public static void main(String[] args) 
	{

		// Creates an object to store the prices
		PricesInfo pricesInfo=new PricesInfo();
		
		Reader readers[]=new Reader[5];
		Thread threadsReader[]=new Thread[5];
		
		// Creates five readers and threads to run them
		for (int i=0; i<3; i++)
		{
			readers[i]=new Reader(pricesInfo);
			threadsReader[i]=new Thread(readers[i]);
		}
		
		// Creates a writer and a thread to run it
		for (int i=0; i<3; i++)
		{
			Writer writer=new Writer(pricesInfo);
			Thread threadWriter=new Thread(writer);
			threadWriter.start();
		}
		
		// Starts the threads
		for (int i=0; i<3; i++){
			threadsReader[i].start();
		}
		
		
	}

}
