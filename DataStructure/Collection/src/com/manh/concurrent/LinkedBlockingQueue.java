package com.manh.concurrent;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.manh.collection.ArrayDeque;


public class LinkedBlockingQueue<E> implements BlockingQueue<E> 
{

	static class Node<E>
	{
		E e;
		
		Node next;
		Node(E e)
		{
			this.e=e;
		}
		
	}
	public LinkedBlockingQueue(int capacity)
	{
		this.capacity=capacity;
		last=head=new Node<E>(null);
	}
	
	private final int capacity;
	 
	private transient Node<E> head;

    /**
     * Tail of linked list.
     * Invariant: last.next == null
     */
    private transient Node<E> last;
    
	private AtomicInteger aInt=new AtomicInteger(0);
	
	private Lock putLock=new ReentrantLock();
	
	private Condition notFull=putLock.newCondition();
	
	private Lock takLock=new ReentrantLock();
	
	private Condition notEmpty=putLock.newCondition();
	
	@Override
	public void put(E e) throws InterruptedException
	{
		 int c = -1;
	     Node<E> node = new Node(e);
	     final Lock putLock = this.putLock;
	     final AtomicInteger count = this.aInt;
	     putLock.lockInterruptibly();
	     try {
	    	 	while (count.get() == capacity) {
	    	 		notFull.await();
	    	 	}
	    	 	enQueue(node);
	    	 	c = count.getAndIncrement();
	    	 	if (c + 1 < capacity)
	    	 		notFull.signal();
	     } finally {
	            putLock.unlock();
	        }
	        if (c == 0)
	            signalNotEmpty();
	        
	}
	
	private void enQueue(Node<E> e)
	{
		last=last.next=e;
	}
	
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e)
	{
		final AtomicInteger integer= aInt;
		if(aInt.get()==capacity)
			return false;
		Node<E> node = new Node(e);
		int c=-1;
		final Lock putLock = this.putLock;
		putLock.lock();
		try{
			if (aInt.get() < capacity)
			{
				enQueue(node);
				c = aInt.getAndIncrement();
				 if (c + 1 < capacity)
					 notFull.signal();
			}
		}finally {
            putLock.unlock();
        }
		if (c == 0)
            signalNotEmpty();
		return c >= 0;
	}

	private void signalNotEmpty()
	{
		final Lock takeLock=this.takLock;
		takeLock.lock();
		try{
			notEmpty.signal();
		}finally{
			takeLock.unlock();;
		}
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
