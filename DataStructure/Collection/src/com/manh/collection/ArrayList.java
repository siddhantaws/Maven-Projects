package com.manh.collection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;


public class ArrayList<E> implements List<E> ,Cloneable, Serializable
{
	private static final long serialVersionUID = 8683452581122892189L;
	
	private transient Object[] elementData;
	
	private static final Object[] EMPTY_ELEMENTDATA = {};
	
	private static final int DEFAULT_CAPACITY = 2;
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	private static int modCount=0;
	/**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;
    
	public ArrayList(int initialCapacity)
	{
		if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
		this.elementData = new Object[initialCapacity];
	}
	
	public ArrayList() 
	{
        this.elementData = EMPTY_ELEMENTDATA;
    }
	
	
	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public boolean contains(Object o) 
	{
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new Itr();
	}

	 private void fastRemove(int index)
	 {
	        modCount++;
	        int numMoved = size - index - 1;
	        if (numMoved > 0)
	            System.arraycopy(elementData, index+1, elementData, index,
	                             numMoved);
	        elementData[--size] = null; // clear to let GC do its work
	 }
	 
	@Override
	public boolean remove(Object o) 
	{
		 if (o == null) {
	            for (int index = 0; index < size; index++)
	                if (elementData[index] == null) {
	                    fastRemove(index);
	                    return true;
	                }
	        } else {
	            for (int index = 0; index < size; index++)
	                if (o.equals(elementData[index])) {
	                    fastRemove(index);
	                    return true;
	                }
	        }
	        return false;
	}

	@Override
	public boolean add(E e) 
	{
		 ensureCapacityInternal(size + 1);  // Increments modCount!!
	     elementData[size++] = e;
	     return true;
	}

	E elementData(int index) 
	{
        return (E) elementData[index];
    }
	
	@Override
	public E get(int index) 
	{
		rangeCheck(index);
        return elementData(index);
	}

	@Override
	public E set(int index, E element) 
	{
		rangeCheck(index);
		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}
	private String outOfBoundsMsg(int index) {
	        return "Index: "+index+", Size: "+size;
	}
	private void rangeCheckForAdd(int index) 
	{
	        if (index > size || index < 0)
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	@Override
	public void add(int index, E element) 
	{
		rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
        elementData[index] = element;
        size++;
	}

	@Override
	public ListIterator<E> listIterator() 
	{
		return new ListItr(0);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) 
	{
		return null;
	}
	
	static void subListRangeCheck(int fromIndex, int toIndex, int size) 
	{
	        if (fromIndex < 0)
	            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
	        if (toIndex > size)
	            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
	        if (fromIndex > toIndex)
	            throw new IllegalArgumentException("fromIndex(" + fromIndex +
	                                               ") > toIndex(" + toIndex + ")");
	    }

	public Object clone() 
	{
        try {
            @SuppressWarnings("unchecked")
                ArrayList<E> v = (ArrayList<E>) super.clone();
            v.elementData = Arrays.copyOf(elementData, size);
            v.modCount=0;
           return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }
	
	private void ensureCapacityInternal(int minCapacity)
	{
		if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		ensureExplicitCapacity(minCapacity);
	}
	
	private void ensureExplicitCapacity(int minCapacity)
	{
		modCount++;
	       if (minCapacity - elementData.length > 0)
	            grow(minCapacity);
	}
	 
	private void grow(int minCapacity) 
	{
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
	
	private static int hugeCapacity(int minCapacity) 
	{
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
	
	@Override
	public int indexOf(Object o)
	{
		if (o == null) 
		{
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else 
        {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
	}

	@Override
	public int lastIndexOf(Object o) 
	{
		if (o == null) 
		{
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else 
        {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
	}

	@Override
	public Object[] toArray() 
	{
		return Arrays.copyOf(elementData, size);
	}
	
	private void rangeCheck(int index) 
	{
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }
	
	 private class Itr implements Iterator<E> {
	        int cursor;       // index of next element to return
	        int lastRet = -1; // index of last element returned; -1 if no such
	        int expectedModCount = modCount;

	        public boolean hasNext() {
	            return cursor != size;
	        }

	        @SuppressWarnings("unchecked")
	        public E next() {
	            checkForComodification();
	            int i = cursor;
	            if (i >= size)
	                throw new NoSuchElementException();
	            Object[] elementData = ArrayList.this.elementData;
	            if (i >= elementData.length)
	                throw new ConcurrentModificationException();
	            cursor = i + 1;
	            return (E) elementData[lastRet = i];
	        }

	        public void remove() {
	            if (lastRet < 0)
	                throw new IllegalStateException();
	            checkForComodification();

	            try {
	                ArrayList.this.remove(lastRet);
	                cursor = lastRet;
	                lastRet = -1;
	                expectedModCount = modCount;
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
	        }

	        final void checkForComodification() {
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	        }
	    }
	 /**
	  * An optimized version of AbstractList.ListItr
	  */
	    private class ListItr extends Itr implements ListIterator<E> 
	    {
	        ListItr(int index) {
	            super();
	            cursor = index;
	        }

	        public boolean hasPrevious() {
	            return cursor != 0;
	        }

	        public int nextIndex() {
	            return cursor;
	        }

	        public int previousIndex() {
	            return cursor - 1;
	        }

	        @SuppressWarnings("unchecked")
	        public E previous() {
	            checkForComodification();
	            int i = cursor - 1;
	            if (i < 0)
	                throw new NoSuchElementException();
	            Object[] elementData = ArrayList.this.elementData;
	            if (i >= elementData.length)
	                throw new ConcurrentModificationException();
	            cursor = i;
	            return (E) elementData[lastRet = i];
	        }

	        public void set(E e) {
	            if (lastRet < 0)
	                throw new IllegalStateException();
	            checkForComodification();

	            try {
	                ArrayList.this.set(lastRet, e);
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
	        }

	        public void add(E e) {
	            checkForComodification();

	            try {
	                int i = cursor;
	                ArrayList.this.add(i, e);
	                cursor = i + 1;
	                lastRet = -1;
	                expectedModCount = modCount;
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
	        }
	    }
	 public ListIterator<E> listIterator(int index) 
	 {
	        if (index < 0 || index > size)
	            throw new IndexOutOfBoundsException("Index: "+index);
	        return new ListItr(index);
	    }   
}
