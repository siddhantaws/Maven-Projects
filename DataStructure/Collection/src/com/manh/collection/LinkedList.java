package com.manh.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList<E> implements List<E> 
{
	
	transient int size = 0;
	protected transient int modCount = 0;
    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient Node<E> last;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
    }
    
    
    private static class Node<E> {
    	E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next)
        {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    	
    }

    public E getFirst() {
    	
    	final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }
    
    public E getLast() 
    {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }
    
    
    private E unlinkFirst(Node<E> f) 
    {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
    
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
    
    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        linkFirst(e);
    }
    
    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        linkLast(e);
    }
    
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }
    
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
    
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }
    
	@Override
	public int indexOf(Object o) 
	{
		 int index = 0;
	        if (o == null) {
	            for (Node<E> x = first; x != null; x = x.next) {
	                if (x.item == null)
	                    return index;
	                index++;
	            }
	        } else {
	            for (Node<E> x = first; x != null; x = x.next) {
	                if (o.equals(x.item))
	                    return index;
	                index++;
	            }
	        }
	        return -1;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) 
	{
		int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) 
	{
		 return indexOf(o) != -1;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new Itr();
	}

	
	private class Itr implements Iterator<E> 
	{
        /**
         * Index of element to be returned by subsequent call to next.
         */
        int cursor = 0;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        int lastRet = -1;

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                LinkedList.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
	
	 private class ListItr extends Itr implements ListIterator<E> {
	        ListItr(int index) {
	            cursor = index;
	        }

	        public boolean hasPrevious() {
	            return cursor != 0;
	        }

	        public E previous() {
	            checkForComodification();
	            try {
	                int i = cursor - 1;
	                E previous = get(i);
	                lastRet = cursor = i;
	                return previous;
	            } catch (IndexOutOfBoundsException e) {
	                checkForComodification();
	                throw new NoSuchElementException();
	            }
	        }

	        public int nextIndex() {
	            return cursor;
	        }

	        public int previousIndex() {
	            return cursor-1;
	        }

	        public void set(E e) {
	            if (lastRet < 0)
	                throw new IllegalStateException();
	            checkForComodification();

	            try {
	                LinkedList.this.set(lastRet, e);
	                expectedModCount = modCount;
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
	        }

	        public void add(E e) {
	            checkForComodification();

	            try {
	                int i = cursor;
	                LinkedList.this.add(i, e);
	                lastRet = -1;
	                cursor = i + 1;
	                expectedModCount = modCount;
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
	        }
	    }
	 
	@Override
	public boolean remove(Object o) {
		if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
	}

	E unlink(Node<E> x)
	{
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
	
	@Override
	public boolean add(E e) {
		 linkLast(e);
		 return true;
	}
	
	private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

	private String outOfBoundsMsg(int index) 
	{
	        return "Index: "+index+", Size: "+size;
	}
	  
	private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
	@Override
	public E get(int index) 
	{
		checkElementIndex(index);
        return node(index).item;
	}

	@Override
	public E set(int index, E element) 
	{
		 checkElementIndex(index);
	     Node<E> x = node(index);
	     E oldVal = x.item;
	     x.item = element;
	      return oldVal;
	}

	@Override
	public void add(int index, E element) 
	{
		checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
	}

	 void linkBefore(E e, Node<E> succ) 
	 {
	        // assert succ != null;
	        final Node<E> pred = succ.prev;
	        final Node<E> newNode = new Node<>(pred, e, succ);
	        succ.prev = newNode;
	        if (pred == null)
	            first = newNode;
	        else
	            pred.next = newNode;
	        size++;
	        modCount++;
	    }

	private void checkPositionIndex(int index) 
	{
	      if (!isPositionIndex(index))
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
	 
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	 public ListIterator<E> listIterator(int index) {
	        checkPositionIndex(index);
	        return new ListItr(index);
	    }
}
