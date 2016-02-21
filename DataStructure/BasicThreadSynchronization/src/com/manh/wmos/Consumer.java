package com.manh.wmos;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable
{
	private List<String > data;
	private Condition notempty ;
	private Condition notFull;
	private Lock lock;
	public Consumer(List<String> strings,Lock lock, Condition notempty,Condition notFull)
	{
		data=strings;
		this.notempty=notempty;
		this.notFull=notFull;
		this.lock=lock;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try{
					lock.lock();
					if(data.size()==0)
					{
						try {
							notFull.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						data.remove(0);
						notempty.signal();
					}
			}finally{
				lock.unlock();
			}
		}
	}
}
