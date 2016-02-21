package com.manh.java7.concurrency.chapter4.recipe1.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This class simulates a server, for example, a web server, that receives
 * requests and uses a ThreadPoolExecutor to execute those requests
 *
 */
public class Server {
	
	/**
	 * ThreadPoolExecutors to manage the execution of the request
	 */
	private ThreadPoolExecutor executor;
	
	/**
	 * Constructor of the class. Creates the executor object
	 */
	public Server(){
		executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
		System.out.println(executor.getPoolSize()+"\t"+getActiveCount());
		
	}
	
	/**
	 * This method is called when a request to the server is made. The 
	 * server uses the executor to execute the request that it receives
	 * @param task The request made to the server
	 */
	public void executeTask(Task task){
		System.out.printf("Server: A new task has arrived\n getPoolSzie()"+getPoolSzie()+" getActiveCount() "+getActiveCount()+"  getCompletedTaskCount()"+getCompletedTaskCount());
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
	}

	/**
	 * This method shuts down the executor
	 */
	public void endServer() {
		executor.shutdown();
	}
	public int getPoolSzie()
	{
		return executor.getPoolSize();
	}
	public int getActiveCount()
	{
		return executor.getActiveCount();
	}
	public long getCompletedTaskCount()
	{
		return executor.getCompletedTaskCount();
	}
}
