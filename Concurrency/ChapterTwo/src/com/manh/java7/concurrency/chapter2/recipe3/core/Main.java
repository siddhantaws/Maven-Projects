package com.manh.java7.concurrency.chapter2.recipe3.core;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.TreeMap;

import com.manh.java7.concurrency.chapter2.recipe3.task.Consumer;
import com.manh.java7.concurrency.chapter2.recipe3.task.EventStorage;
import com.manh.java7.concurrency.chapter2.recipe3.task.Producer;

/**
 * Main class of the example
 */
public class Main {

	/**
	 * Main method of the example
	 */

	public static void main(String[] args) {
		
		// Creates an event storage
		EventStorage storage=new EventStorage();
		
		// Creates a Producer and a Thread to run it
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);

		// Creates a Consumer and a Thread to run it
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		
		// Starts the thread
		thread2.start();
		thread1.start();
	}

}
