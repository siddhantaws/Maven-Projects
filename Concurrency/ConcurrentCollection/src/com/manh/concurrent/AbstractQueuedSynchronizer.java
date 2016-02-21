package com.manh.concurrent;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;


import sun.misc.Unsafe;

public abstract class AbstractQueuedSynchronizer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	 private transient volatile Node head;

	 private transient volatile Node tail;

	 private volatile int state;

	 protected final int getState() 
	 {
	        return state;
	 }

	 protected final void setState(int newState) 
	 {
	        state = newState;
	 }

	 private static final Unsafe unsafe = getUnsafe();
	 private static final long stateOffset;
	 private static final long headOffset;
	 private static final long tailOffset;
	 private static final long waitStatusOffset;
	 private static final long nextOffset;
	    
	 static {
	        try {
	        	stateOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getField("state"));
	        	headOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getField("head"));
	        	tailOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("tail"));
	        	waitStatusOffset =unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("waitStatus"));
	        	nextOffset= unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("next"));
	        } catch (Exception ex) { throw new Error(ex); }
	    }
	 
	private static Unsafe getUnsafe ()
	{
		Unsafe unsafe=null;
		if(unsafe==null)
		{
			try {
				Class cls=Class.forName("sun.misc.Unsafe");
				Field field=cls.getDeclaredField("theUnsafe");
				field.setAccessible(true);
				unsafe=(Unsafe)field.get(null);
			} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return unsafe;
	}
	
	private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) 
    {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() 
    {
        return exclusiveOwnerThread;
    }
	
	static final class Node 
	{
		 /** Marker to indicate a node is waiting in shared mode */
        static final Node SHARED = new Node();
        /** Marker to indicate a node is waiting in exclusive mode */
        static final Node EXCLUSIVE = null;
        /** waitStatus value to indicate thread has cancelled */
        static final int CANCELLED =  1;
        /** waitStatus value to indicate successor's thread needs unparking */
        static final int SIGNAL    = -1;
        /** waitStatus value to indicate thread is waiting on condition */
        static final int CONDITION = -2;
        /**
         * waitStatus value to indicate the next acquireShared should
         * unconditionally propagate
         */
        static final int PROPAGATE = -3;

        volatile int waitStatus;

        volatile Node prev;

        
        volatile Node next;

       
        volatile Thread thread;

       
        Node nextWaiter;
        Node(){}
        Node(Thread thread, Node mode) 
        {     
            this.nextWaiter = mode;
            this.thread = thread;
        }
        
        final Node predecessor()
        {
        	Node n=prev;
        	return n;
        }

	}
	protected final boolean compareAndSetState(int currvalue,int updated)
	{
		return unsafe.compareAndSwapInt(this, stateOffset, currvalue, updated);
	}
	
	protected final boolean compareAndSetTail(Node expect,Node update)
	{
		return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
	}
	
	protected final boolean compareAndSetHead(Node update)
	{
		return unsafe.compareAndSwapObject(this, headOffset, null, update);
	}
	
	protected Node addWriter(Node n)
	{
		Node node=new Node(Thread.currentThread(), n);
		
		Node n1=tail;
		if(n1==null)
		{
			return enque(node);
		}else
		{
			node.prev=n1;
			if(compareAndSetTail(n1, node))
			{
				n1.next=node;
				return node;
			}
		}
	}
	
	protected boolean acquireQueued(final Node node)
	{
		Node n=node.predecessor();
		return shouldParkAfterFailedAcquire(n, node);
			
	}
	
	protected boolean shouldParkAfterFailedAcquire(Node pred,Node node)
	{
		final int stat=pred.waitStatus;
		if(stat==0)
		{
			if(compareAndSetWaitStat(pred, waitStatusOffset, 0, Node.SIGNAL))
			{
				LockSupport.park(this);
			}	
		}
	}
	
	protected final boolean compareAndSetWaitStat(Node node ,long offset, int expect ,int update)
	{
		return unsafe.compareAndSwapInt(node	, offset, expect, update);
	}
	
	protected Node enque(Node node)
	{
		for(;;)
		{
			Node t=tail;
			if(t==null)
			{
				if(compareAndSetHead(new Node()))
				{
					tail=head;
				}
			}else
			{
				node.prev=t;
				if(compareAndSetTail(t, node))
					t.next=node;
				return t;
			}
		}
	}
	
}
