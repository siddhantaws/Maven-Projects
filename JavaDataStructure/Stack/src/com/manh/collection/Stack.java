package com.manh.collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> 
{
	protected transient int modCount = 0;
	
	protected int elementCount;
	
	protected Object[] elementData;
	
	protected int capacityIncrement;
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public Stack(int initialCapacity)
	{
		if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = 0;
	}
	
	public E push(E e)
	{
		addElement(e);
		return e;
	}
	protected void addElement(E e)
	{
		  modCount++;
		  ensureCapacityHelper(elementCount + 1);
		  elementData[elementCount++] = e;
	}
	
	private void ensureCapacityHelper(int minCapacity) 
	{
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
	
	 private void grow(int minCapacity) {
	        // overflow-conscious code
	        int oldCapacity = elementData.length;
	        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
	                                         capacityIncrement : oldCapacity);
	        if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
	        if (newCapacity - MAX_ARRAY_SIZE > 0)
	            newCapacity = hugeCapacity(minCapacity);
	        elementData = Arrays.copyOf(elementData, newCapacity);
	 }
	 private static int hugeCapacity(int minCapacity) 
	 {
	        if (minCapacity < 0) // overflow
	            throw new OutOfMemoryError();
	        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	 }
	 public E pop() 
	 {
	        E       obj;
	        int     len = size();

	        obj = peek();
	        removeElementAt(len - 1);

	        return obj;
	 }
	 public int size() 
	 {
	        return elementCount;
	 }
	 
	 public E peek() 
	 {
	        int     len = size();

	        if (len == 0)
	            throw new EmptyStackException();
	        return elementAt(len - 1);
	 }
	 public E elementAt(int index) 
	 {
	        if (index >= elementCount) {
	            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
	        }

	        return elementData(index);
	  }
	 E elementData(int index) 
	 {
	        return (E) elementData[index];
	 }
	 
	 public void removeElementAt(int index) 
	 {
	        modCount++;
	        if (index >= elementCount) {
	            throw new ArrayIndexOutOfBoundsException(index + " >= " +
	                                                     elementCount);
	        }
	        else if (index < 0) {
	            throw new ArrayIndexOutOfBoundsException(index);
	        }
	        int j = elementCount - index - 1;
	        if (j > 0) {
	            System.arraycopy(elementData, index + 1, elementData, index, j);
	        }
	        elementCount--;
	        elementData[elementCount] = null; /* to let gc do its work */
	 }
	 public boolean isEmpty()
	 {
		 return elementCount==0;
	 }
	 public void reverseStack()
	 {
		 E e = pop();
		 if (size() != 1)
	           reverseStack ();
		 placeCurrAtBottomOfStack(e);
	 }
	 public void placeCurrAtBottomOfStack(E e)
	 {
		 E e1 = pop();
		 if (size() == 0)
	          push(e); 
		 else
	         placeCurrAtBottomOfStack(e);
		 push(e1);
	 }
	 @Override
	public String toString() {
		return super.toString();
	}
	
	 public int[] findingSpans(int[]  arrays)
	 {
		 int spans[]=new int[arrays.length];
		 Stack<Integer> stack=new Stack<>(10);
		 int p=0;
		 for(int i=0;i<arrays.length;i++)
		 {
			 while(!stack.isEmpty() && arrays[i]> arrays[stack.peek()])
				 stack.pop();
			 if(stack.isEmpty())
				 p=-1;
			 else
				 p=stack.peek();
			 spans[i]=i-p;
			 stack.push(i);
		 }
		 return spans;
	 }
}
