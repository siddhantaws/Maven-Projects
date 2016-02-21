package com.manh.concurrent;

import java.util.ArrayDeque;

public class CircularQueue<E> implements Queue<E> 
{
	private static final int capacity = 10;
    private Object[] Q;
    private final int N; // capacity
    private int f = 0;
    private int r = 0;
    
    public CircularQueue()
    {
    	this(capacity);
    }
    
    public CircularQueue(int capacity)
    {
    	N=capacity;
    	Q=new Object[N];
    }
    
    public int size()
    {
    	if(r>f)
    		return r-f;
    	return N-f+r;
    }
    
    public boolean isEmpty()
    {
    	return r==f ?  true : false; 
    }
	@Override
	public boolean add(E e) 
	{
		if(isFull())
			resizeQueue();
		Q[r]=e;
		r=(r + 1)%N;
		return true;
	}
	public void reverse(int k)
	{
		reverse(Q ,k,0);
	}
	public void reverse(Object[] Q ,int k,int num)
	{
		if(k>=0)
		{
			int a=k-1;
			num=num+1;
			reverse(Q ,a,num);
			swap(k,num-1);
		}
	}
	
	public void swap(int k,int num)
	{
		Object temp=Q[k];
		Q[k]=Q[num];
		Q[num]=temp;
	}
	public void resizeQueue()
	{
		int head=f;
		int rear=r;
		Object[] temp=new Object[size()*2];
		System.arraycopy(Q, head, temp, rear, size());
		Q=(Object[])temp;
	}
	
	public boolean isFull()
	{
		return (r+1)%N==f;
	}
	
	@Override
	public boolean offer(E e) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() 
	{
		E e =(E) Q[f];
		Q[f] = null;
		f = (f + 1) % N;
		return e;
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

}
