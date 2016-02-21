package com.manh.pool.example;

import java.io.PrintWriter;
import java.util.Deque;

import com.manh.pool.PooledObject;
import com.manh.pool.PooledObjectState;

public class WorkerThread {/*extends Thread implements PooledObject<WorkerThread> {
	private boolean stopped;

	private Object result;

	private boolean running;

	private String className;
	private String methodName;
	private Object[] methodParams;
	private Object syncObject;
	private boolean done;
	private Class[] parmTypes;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public void run() {
		running = true;
		while (!stopped) { // The thread keeps running.
			if (done) { // We are waiting for a task now.
				synchronized (this) {
					try {
						this.wait(); // Wait until we get a task to execute.
					} catch (InterruptedException e) {
						stopped = true;
						System.err.println(e);
					}
				}
			} else { // There is a task....let us execute it.
				try {
					execute();
					if (syncObject != null) {
						synchronized (syncObject) {
							syncObject.notifyAll(); // Notify the completion.
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					reset();
				}
			}
		}
	}

	private void execute() {
	      try {
	         Class cls =this. getClass();
	         Object obj = cls.newInstance();
	         this.result = MethodUtils.invokeExactMethod(obj, this
	               .getMethodName(), this.getMethodParams(), this.getParmTypes());
	         log.debug(" #### Execution Result = " + result);
	      } catch (Exception e) {
	         log.error("Exception - " + e);
	      }
	   }
	public void reset() {
		this.done = true;
		this.className = null;
		this.methodName = null;
		this.methodParams = null;
		this.parmTypes = null;
		this.syncObject = null;
	}

	public synchronized void execute(String clsName, String methName, Object[] params, Class[] paramTypes,
			Object synObj) {
		this.className = clsName;
		this.methodName = methName;
		this.methodParams = params;
		this.syncObject = synObj;
		this.parmTypes = paramTypes;
		this.done = false;

		if (!running) { // If this is the first time, then kick off the thread
			this.setDaemon(true);
			this.start();
		} else { // We already have a thread running, so wake up the waiting
					// thread
			this.notifyAll();
		}
	}

	@Override
	public WorkerThread getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreateTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getActiveTimeMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getIdleTimeMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastBorrowTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastReturnTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastUsedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(PooledObject<WorkerThread> other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean startEvictionTest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean endEvictionTest(Deque<PooledObject<WorkerThread>> idleQueue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allocate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deallocate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLogAbandoned(boolean logAbandoned) {
		// TODO Auto-generated method stub

	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStackTrace(PrintWriter writer) {
		// TODO Auto-generated method stub

	}

	public PooledObjectState getStates() {
		return PooledObjectState.IDLE;
	}

	@Override
	public void markAbandoned() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markReturning() {
		// TODO Auto-generated method stub

	}
*/}
