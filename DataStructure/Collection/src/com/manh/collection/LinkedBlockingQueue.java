package com.manh.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueue<E> implements BlockingQueue<E> {

	/**
     * Linked list node class
     */
    static class Node<E> {
        E item;

        /**
         * One of:
         * - the real successor Node
         * - this Node, meaning the successor is head.next
         * - null, meaning there is no successor (this is the last node)
         */
        Node<E> next;

        Node(E x) { item = x; }
    }
    
    /** The capacity bound, or Integer.MAX_VALUE if none */
    private final int capacity;

    /** Current number of elements */
    private final AtomicInteger count = new AtomicInteger(0);

    /**
     * Head of linked list.
     * Invariant: head.item == null
     */
    private transient Node<E> head;

    /**
     * Tail of linked list.
     * Invariant: last.next == null
     */
    private transient Node<E> last;

    /** Lock held by take, poll, etc */
    private final ReentrantLock takeLock = new ReentrantLock();

    /** Wait queue for waiting takes */
    private final Condition notEmpty = takeLock.newCondition();

    /** Lock held by put, offer, etc */
    private final ReentrantLock putLock = new ReentrantLock();

    /** Wait queue for waiting puts */
    private final Condition notFull = putLock.newCondition();


    public LinkedBlockingQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        last = head = new Node<E>(null);
    }
    
    public int size() {
        return count.get();
    }
    
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		 final AtomicInteger count = this.count;
	        if (count.get() == 0)
	            return null;
	        E x = null;
	        int c = -1;
	        final ReentrantLock takeLock = this.takeLock;
	        takeLock.lock();
	        try {
	            if (count.get() > 0) {
	                x = dequeue();
	                c = count.getAndDecrement();
	                if (c > 1)
	                    notEmpty.signal();
	            }
	        } finally {
	            takeLock.unlock();
	        }
	        if (c == capacity)
	            signalNotFull();
	        return x;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		if (count.get() == 0)
            return null;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            Node<E> first = head.next;
            if (first == null)
                return null;
            else
                return first.item;
        } finally {
            takeLock.unlock();
        }
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator() 
	{
	      return new Itr();
	}
	 
	@Override
	public boolean offer(E e) 
	{
		if (e == null) throw new NullPointerException();
        final AtomicInteger count = this.count;
        if (count.get() == capacity)
            return false;
        int c = -1;
        Node<E> node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            if (count.get() < capacity) {
                enqueue(node);
                c = count.getAndIncrement();
                if (c + 1 < capacity)
                    notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        if (c == 0)
            signalNotEmpty();
        return c >= 0;
	}
	
	/**
     * Links node at end of queue.
     *
     * @param node the node
     */
    private void enqueue(Node<E> node) {
        // assert putLock.isHeldByCurrentThread();
        // assert last.next == null;
        last = last.next = node;
    }

	 /**
     * Signals a waiting take. Called only from put/offer (which do not
     * otherwise ordinarily lock takeLock.)
    */
    private void signalNotEmpty()
    {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }
    
	@Override
	public void put(E e) throws InterruptedException 
	{
		 if (e == null) throw new NullPointerException();
	        // Note: convention in all put/take/etc is to preset local var
	        // holding count negative to indicate failure unless set.
	        int c = -1;
	        Node<E> node = new Node(e);
	        final ReentrantLock putLock = this.putLock;
	        final AtomicInteger count = this.count;
	        putLock.lockInterruptibly();
	        try {
	            /*
	             * Note that count is used in wait guard even though it is
	             * not protected by lock. This works because count can
	             * only decrease at this point (all other puts are shut
	             * out by lock), and we (or some other waiting put) are
	             * signalled if it ever changes from capacity. Similarly
	             * for all other uses of count in other wait guards.
	             */
	            while (count.get() == capacity) {
	                notFull.await();
	            }
	            enqueue(node);
	            c = count.getAndIncrement();
	            if (c + 1 < capacity)
	                notFull.signal();
	        } finally {
	            putLock.unlock();
	        }
	        if (c == 0)
	            signalNotEmpty();
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit)
			throws InterruptedException {
		 if (e == null) throw new NullPointerException();
	        long nanos = unit.toNanos(timeout);
	        int c = -1;
	        final ReentrantLock putLock = this.putLock;
	        final AtomicInteger count = this.count;
	        putLock.lockInterruptibly();
	        try {
	            while (count.get() == capacity) {
	                if (nanos <= 0)
	                    return false;
	                nanos = notFull.awaitNanos(nanos);
	            }
	            enqueue(new Node<E>(e));
	            c = count.getAndIncrement();
	            if (c + 1 < capacity)
	                notFull.signal();
	        } finally {
	            putLock.unlock();
	        }
	        if (c == 0)
	            signalNotEmpty();
	        return true;
	}

	@Override
	public E take() throws InterruptedException 
	{
		E x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        if (c == capacity)
            signalNotFull();
        return x;
	}
	
	/**
     * Signals a waiting put. Called only from take/poll.
    */
    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }
    
	private E dequeue() 
	{
        // assert takeLock.isHeldByCurrentThread();
        // assert head.item == null;
        Node<E> h = head;
        Node<E> first = h.next;
        h.next = h; // help GC
        head = first;
        E x = first.item;
        first.item = null;
        return x;
    }

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		E x = null;
        int c = -1;
        long nanos = unit.toNanos(timeout);
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                if (nanos <= 0)
                    return null;
                nanos = notEmpty.awaitNanos(nanos);
            }
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        if (c == capacity)
            signalNotFull();
        return x;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
     * Lock to prevent both puts and takes.
     */
    void fullyLock() {
        putLock.lock();
        takeLock.lock();
    }

    /**
     * Unlock to allow both puts and takes.
     */
    void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
    }
    
    /**
     * Unlinks interior Node p with predecessor trail.
     */
    void unlink(Node<E> p, Node<E> trail) 
    {
        // assert isFullyLocked();
        // p.next is not changed, to allow iterators that are
        // traversing p to maintain their weak-consistency guarantee.
        p.item = null;
        trail.next = p.next;
        if (last == p)
            last = trail;
        if (count.getAndDecrement() == capacity)
            notFull.signal();
    }
    
	@Override
	public boolean remove(Object o) 
	{
		 if (o == null) return false;
	        fullyLock();
	        try {
	            for (Node<E> trail = head, p = trail.next;
	                 p != null;
	                 trail = p, p = p.next) {
	                if (o.equals(p.item)) {
	                    unlink(p, trail);
	                    return true;
	                }
	            }
	            return false;
	        } finally {
	            fullyUnlock();
	        }
	}

	@Override
	public boolean contains(Object o) 
	{
		if (o == null) return false;
        fullyLock();
        try {
            for (Node<E> p = head.next; p != null; p = p.next)
                if (o.equals(p.item))
                    return true;
            return false;
        } finally {
            fullyUnlock();
        }
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
	private class Itr implements Iterator<E> {
        /*
         * Basic weakly-consistent iterator.  At all times hold the next
         * item to hand out so that if hasNext() reports true, we will
         * still have it to return even if lost race with a take etc.
         */
        private Node<E> current;
        private Node<E> lastRet;
        private E currentElement;

        Itr() {
            fullyLock();
            try {
                current = head.next;
                if (current != null)
                    currentElement = current.item;
            } finally {
                fullyUnlock();
            }
        }

        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next live successor of p, or null if no such.
         *
         * Unlike other traversal methods, iterators need to handle both:
         * - dequeued nodes (p.next == p)
         * - (possibly multiple) interior removed nodes (p.item == null)
         */
        private Node<E> nextNode(Node<E> p) {
            for (;;) {
                Node<E> s = p.next;
                if (s == p)
                    return head.next;
                if (s == null || s.item != null)
                    return s;
                p = s;
            }
        }

        public E next() {
            fullyLock();
            try {
                if (current == null)
                    throw new NoSuchElementException();
                E x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
                return x;
            } finally {
                fullyUnlock();
            }
        }

        public void remove() {
            if (lastRet == null)
                throw new IllegalStateException();
            fullyLock();
            try {
                Node<E> node = lastRet;
                lastRet = null;
                for (Node<E> trail = head, p = trail.next;
                     p != null;
                     trail = p, p = p.next) {
                    if (p == node) {
                        unlink(p, trail);
                        break;
                    }
                }
            } finally {
                fullyUnlock();
            }
        }
    }
}
