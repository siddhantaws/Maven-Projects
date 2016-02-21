package com.manh.pool.example;

import com.manh.pool.PooledObjectFactory;
import com.manh.pool.impl.GenericObjectPool;
import com.manh.pool.impl.GenericObjectPoolConfig;

public class ThreadPool extends GenericObjectPool<WorkerThread> {

	public ThreadPool(PooledObjectFactory<WorkerThread> factory) {
		super(factory);
		this.setMaxIdle(2); // Maximum idle threads.
		// this.setMin// Maximum active threads.
		this.setMinEvictableIdleTimeMillis(30000); // Evictor runs every 30
													// secs.
		this.setTestOnBorrow(true); // Check if the thread is still valid.
		// this.setMaxWait(1000); // Wait 1 second till a thread is available
	}

	// Second constructor.
	public ThreadPool(PooledObjectFactory<WorkerThread> objFactory, GenericObjectPoolConfig config) {
		super(objFactory, config);
	}
	@Override
	public WorkerThread borrowObject() throws Exception {
		// TODO Auto-generated method stub
		return super.borrowObject();
	}
	@Override
	public void returnObject(WorkerThread obj) {
		// TODO Auto-generated method stub
		super.returnObject(obj);
	}
}
