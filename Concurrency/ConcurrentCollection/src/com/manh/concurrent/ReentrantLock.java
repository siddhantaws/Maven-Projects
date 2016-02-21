package com.manh.concurrent;

import java.io.Serializable;


public class ReentrantLock implements Lock , Serializable
{

	private static final long serialVersionUID = 1L;

	/** Synchronizer providing all implementation mechanics */
    private final Sync sync;
    
    public ReentrantLock()
    {
    	this.sync=new FairSync();
    }
    
    abstract static class Sync extends AbstractQueuedSynchronizer
    {
    	abstract boolean lock();
    	
		private static final long serialVersionUID = 1L;
    	
    }
	 
   static final class FairSync extends Sync
   {
	   
	@Override
	boolean lock() 
	{
		final Thread current = Thread.currentThread();
		final int c = getState();
		if(c==0)
		{
			compareAndSetState(0, 1);
			setExclusiveOwnerThread(current);
			return true;
		}else
		{
			acquireQueued(addWriter(Node.EXCLUSIVE));
			return true;
		}
	}
	
	   
   } 
    
	@Override
	public void luck()
	{
		sync.lock();
	}

	@Override
	public void unluck() 
	{
		
	}

}
