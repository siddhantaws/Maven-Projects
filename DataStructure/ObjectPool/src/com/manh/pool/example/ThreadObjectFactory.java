package com.manh.pool.example;

import com.manh.pool.PoolableObjectFactory;
import com.manh.pool.PooledObject;
import com.manh.pool.PooledObjectFactory;

public class ThreadObjectFactory {/*implements PoolableObjectFactory<WorkerThread>{

	@Override
	public WorkerThread makeObject() throws Exception {
		return new WorkerThread();
	}

	@Override
	public void destroyObject(WorkerThread obj) throws Exception {
		if (obj instanceof WorkerThread) {
	         WorkerThread rt = (WorkerThread) obj;
	         rt.setStopped(true);//Make the running thread stop
	      }
	}

	@Override
	public boolean validateObject(WorkerThread obj) {
		if (obj instanceof WorkerThread) {
	         WorkerThread rt = (WorkerThread) obj;
	         if (rt.isRunning()) {
	            if (rt.getThreadGroup() == null) {
	               return false;
	            }
	            return true;
	         }
	      }
	      return true;
	}

	@Override
	public void activateObject(WorkerThread p) throws Exception {
		System.out.println(" activateObject...");
	}

	@Override
	public void passivateObject(WorkerThread obj) throws Exception 
	{
		if (obj instanceof WorkerThread) {
	         WorkerThread wt = (WorkerThread) obj;
	         wt.setResult(null); //Clean up the result of the execution
	      }
		
	}

	

*/}
