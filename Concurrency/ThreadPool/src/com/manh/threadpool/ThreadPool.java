package com.manh.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool 
{
	private BlockingQueue taskQueue = null;
	
	private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;
    
    
    public ThreadPool(int noOfThreads, int maxNoOfTasks)
    {
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }
    
    public synchronized void  execute(Runnable task) throws Exception
    {
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.offer(task);
        
    }
    
    public synchronized void stop()
    {
        this.isStopped = true;
        for(PoolThread thread : threads)
        {
           thread.stop();
        }
    }
}
