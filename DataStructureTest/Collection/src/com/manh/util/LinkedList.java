package com.manh.util;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<E> implements List<E> 
{
	private int size;
	
	private int modCount;
	
	Node<E> first=null;
	
	private Node<E> last;

	static class Node<E>
	{
		E e;
		Node<E> next;
		Node<E> prev;
		Node(E e,Node<E> next,Node<E> prev)
		{
			this.e=e;
			this.next=next;
			this.prev=prev;
		}
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	class Itr<E> implements Iterator<E>
	{
		Node<E> currNode=null;
		Itr()
		{
			currNode=(Node<E>)first;
		}
		
		@Override
		public boolean hasNext() 
		{
			return currNode==null ? false :true;
		}

		@Override
		public E next() 
		{
			Node<E> e=currNode;
			currNode=currNode.next;
			return e.e;
		}

		@Override
		public void remove() 
		{
			
		}		
	}
	
	@Override
	public int size() 
	{
		return size<0 ? -1 : size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new Itr();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{

	}

	public void addLast(E e)
	{
		Node<E> nodeL=last;
		Node<E> currNode=new Node<E>(e, null, nodeL);
		if(nodeL==null)
			first=last=currNode;
		else
		{
			last.next=currNode;
			last=currNode;
		}
			
		size++;
		modCount++;
	}
	@Override
	public boolean add(E e) 
	{
		addLast(e);
		return true;
	}

	@Override
	public void set(E e, int index) 
	{
		Node<E> node=getIndex(index);
		Node<E> currNode=new Node<E>(e, node, node.prev);
		size++;
		modCount++;
	}

	private Node<E> getIndex(int index)
	{
		if(index>size)
			throw new IndexOutOfBoundsException();
		Node<E> node=first;
		for(int i=0;i<index;i++)
		{
			node=node.next;
		}
		return node;
	}
	
	@Override
	public void addFirst(E e) 
	{
		Node<E> nodeF=first;
		Node<E> currNode=new Node<E>(e, nodeF, null);
		if(nodeF==null)
			first=last=currNode;
		else
		{
			first=currNode;
			first.next=nodeF;
		}
		size++;
		modCount++;
	}

	@Override
	public boolean remove(Object o) 
	{
		return false;
	}
	public void reverseLinkedList()
	{
		Node<E> node=reverse(first);
		first=node;
	}
	
	public void printReverserOrder()
	{
		print(first);
	}
	
	private void print(Node<E> head)
	{
		if(head!=null )
		{
			print(head.next);
			System.out.println(head.e);
		}
	}
	
	public void reverseIteratively()
	{
		first=reverseIteratively(first);
	}
	
	private Node reverseIteratively(Node node) 
	{
		Node temp=null ;Node currNext;
		while(node!=null)
		{
			currNext=node.next;
			node.next=temp;
			temp=node;
			node=currNext;
		}
		return temp;
	}
	public void reversePair()
	{
		first=reversePair(first);
	}
	protected Node<E> reversePair(Node<E> head)
	{
		if(head==null || head.next==null)
			return head;
		else
		{
			Node<E> temp= head.next;
			head.next=temp.next;
			temp.next=head;
			head=temp;
			head.next.next=reversePair(head.next.next);
		}
		return head;	
	}
	public Node<E> reverse(Node<E> head)
	{
		if(head!=null &&  head.next!=null)
		{
			Node<E> node=reverse(head.next);
			head.next.next = head;
			head.next = null; //
			return node;
		}
		return head;
	}
}

