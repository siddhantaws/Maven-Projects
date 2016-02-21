package com.manh.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrayDeque<E> implements Deque<E> 
{	
	/**
     * The array in which the elements of the deque are stored.
     * The capacity of the deque is the length of this array, which is
     * always a power of two. The array is never allowed to become
     * full, except transiently within an addX method where it is
     * resized (see doubleCapacity) immediately upon becoming full,
     * thus avoiding head and tail wrapping around to equal each
     * other.  We also guarantee that all array cells not holding
     * deque elements are always null.
     */
    private transient E[] elements;

    /**
     * The index of the element at the head of the deque (which is the
     * element that would be removed by remove() or pop()); or an
     * arbitrary number equal to tail if the deque is empty.
     */
    private transient int head;

    /**
     * The index at which the next element would be added to the tail
     * of the deque (via addLast(E), add(E), or push(E)).
     */
    private transient int tail;

    /**
     * The minimum capacity that we'll use for a newly created deque.
     * Must be a power of 2.
     */
    private static final int MIN_INITIAL_CAPACITY = 8;

    // ******  Array allocation and resizing utilities ******
    
    public ArrayDeque() 
    {
        elements = (E[]) new Object[2];
    }
    
	@Override
	public void addFirst(E e) 
	{
		if (e == null)
			throw new NullPointerException();
	    elements[head = (head - 1) & 
	    		(elements.length - 1)] = e;
	    if (head == tail)
	    	doubleCapacity();
	}

	 /**
     * Returns <tt>true</tt> if this deque contains no elements.
     *
     * @return <tt>true</tt> if this deque contains no elements
     */
    public boolean isEmpty() {
        return head == tail;
    }
    
	 private void doubleCapacity()
	 {
	        assert head == tail;
	        int p = head;
	        int n = elements.length;
	        int r = n - p; // number of elements to the right of p
	        int newCapacity = n << 1;
	        if (newCapacity < 0)
	            throw new IllegalStateException("Sorry, deque too big");
	        Object[] a = new Object[newCapacity];
	        System.arraycopy(elements, p, a, 0, r);
	        System.arraycopy(elements, 0, a, r, p);
	        elements = (E[])a;
	        head = 0;
	        tail = n;
	    }
	 
	@Override
	public void addLast(E e) 
	{
		if (e == null)
            throw new NullPointerException();
        elements[tail] = e;
        if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            doubleCapacity();
	}

	@Override
	public boolean offerFirst(E e) 
	{
		addFirst(e);
        return true;	
    }

	@Override
	public boolean offerLast(E e) 
	{
		addLast(e);
	    return true;
	}

	@Override
	public E removeFirst() 
	{
		 E x = pollFirst();
	     if (x == null)
	            throw new NoSuchElementException();
	    return x;
	}

	@Override
	public E removeLast() 
	{
		E x = pollLast();
        if (x == null)
            throw new NoSuchElementException();
        return x;
	}

	@Override
	public E pollFirst() 
	{
		int h = head;
        E result = elements[h]; // Element is null if deque empty
        if (result == null)
            return null;
        elements[h] = null;     // Must null out slot
        head = (h + 1) & (elements.length - 1);
        return result;
	}

	@Override
	public E pollLast() {
		int t = (tail - 1) & (elements.length - 1);
        E result = elements[t];
        if (result == null)
            return null;
        elements[t] = null;
        tail = t;
        return result;
	}

	@Override
	public E getFirst() 
	{
		 E x = elements[head];
	     if (x == null)
	            throw new NoSuchElementException();
	     return x;
	}

	@Override
	public E getLast()
	{
		 E x = elements[(tail - 1) & (elements.length - 1)];
	     if (x == null)
	            throw new NoSuchElementException();
	     return x;
	}

	@Override
	public E peekFirst() {
		 return elements[head]; // elements[head] is null if deque empty
	}

	@Override
	public E peekLast() {
		 return elements[(tail - 1) & (elements.length - 1)];
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		 if (o == null)
	            return false;
	        int mask = elements.length - 1;
	        int i = head;
	        E x;
	        while ( (x = elements[i]) != null) {
	            if (o.equals(x)) {
	                delete(i);
	                return true;
	            }
	            i = (i + 1) & mask;
	        }
	        return false;
	}
	
	private void checkInvariants() 
	{
	        assert elements[tail] == null;
	        assert head == tail ? elements[head] == null :
	            (elements[head] != null &&
	             elements[(tail - 1) & (elements.length - 1)] != null);
	        assert elements[(head - 1) & (elements.length - 1)] == null;
	}
	/**
     * Removes the element at the specified position in the elements array,
     * adjusting head and tail as necessary.  This can result in motion of
     * elements backwards or forwards in the array.
     *
     * <p>This method is called delete rather than remove to emphasize
     * that its semantics differ from those of {@link List#remove(int)}.
     *
     * @return true if elements moved backwards
     */
    private boolean delete(int i) {
        checkInvariants();
        final E[] elements = this.elements;
        final int mask = elements.length - 1;
        final int h = head;
        final int t = tail;
        final int front = (i - h) & mask;
        final int back  = (t - i) & mask;

        // Invariant: head <= i < tail mod circularity
        if (front >= ((t - h) & mask))
            throw new ConcurrentModificationException();

        // Optimize for least element motion
        if (front < back) {
            if (h <= i) {
                System.arraycopy(elements, h, elements, h + 1, front);
            } else { // Wrap around
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = elements[mask];
                System.arraycopy(elements, h, elements, h + 1, mask - h);
            }
            elements[h] = null;
            head = (h + 1) & mask;
            return false;
        } else {
            if (i < t) { // Copy the null tail as well
                System.arraycopy(elements, i + 1, elements, i, back);
                tail = t - 1;
            } else { // Wrap around
                System.arraycopy(elements, i + 1, elements, i, mask - i);
                elements[mask] = elements[0];
                System.arraycopy(elements, 1, elements, 0, t);
                tail = (t - 1) & mask;
            }
            return true;
        }
    }
    
	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E e)
	{
		addLast(e);
        return true;
	}

	@Override
	public boolean offer(E e) 
	{
		return offerLast(e);
	}

	@Override
	public E remove() 
	{
		return removeFirst();
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E element() 
	{
		return getFirst();	
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public void push(E e) 
	{
		  addFirst(e);
	}

	@Override
	public E pop() {
		 return removeFirst();
	}

	@Override
	public boolean remove(Object o) {
		return removeFirstOccurrence(o);
	}

	@Override
	public boolean contains(Object o) 
	{
		 if (o == null)
	            return false;
	        int mask = elements.length - 1;
	        int i = head;
	        E x;
	        while ( (x = elements[i]) != null) {
	            if (o.equals(x))
	                return true;
	            i = (i + 1) & mask;
	        }
	        return false;
	}

	@Override
	public int size() 
	{
		 return (tail - head) & (elements.length - 1);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
