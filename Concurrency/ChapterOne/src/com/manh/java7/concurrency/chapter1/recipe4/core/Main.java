package com.manh.java7.concurrency.chapter1.recipe4.core;

import java.util.concurrent.TimeUnit;

import com.manh.java7.concurrency.chapter1.recipe4.task.FileSearch;

/**
 *  Main class of the example. Search for the autoexect.bat file
 *  on the Windows root folder and its subfolders during ten seconds
 *  and then, interrupts the Thread
 */
public class Main {

	/**
	 * Main method of the core. Search for the autoexect.bat file
	 * on the Windows root folder and its subfolders during ten seconds
	 * and then, interrupts the Thread
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates the Runnable object and the Thread to run it
		FileSearch searcher=new FileSearch("D:\\","Siddhanta\\Java Docs\\Ebooks\\Java Concurrency\\Java 7 Concurrency Cookbook\\7881_code\\Chapter 1\\ch1_recipe04\\src"
				+ "\\com\\packtpub\\java7\\concurrency\\chapter1\\recipe4\\task\\FileSearch.java");
		Thread thread=new Thread(searcher);
		
		// Starts the Thread
		thread.start();
		
		// Wait for ten seconds
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Interrupts the thread
		thread.interrupt();
	}

}
