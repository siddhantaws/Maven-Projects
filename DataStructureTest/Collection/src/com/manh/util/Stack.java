package com.manh.util;

import java.util.Iterator;

public class Stack<E> 
{
	
	private Node<E> head;
	
	public Stack()
	{
		
	}
	public void push(E e)
	{
		if(head==null)
			head=new Node<>(e, null);
		else
			head=new Node<>(e, head);
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	public E top()
	{
		if(head==null)
			throw new NullPointerException();
		return head.e;
	}
	
	public E pop()
	{
		if(head==null)
			throw new NullPointerException();
		E e=head.e;
		head=head.next;
		return e;
	}
	
	public Iterator<E> iterator()
	{
		return new Itr<>();
	}
	class Itr<E> implements Iterator<E>
	{
		private Node currNode=head;
		@Override
		public boolean hasNext() 
		{
			return currNode!=null;
		}

		@Override
		public E next() 
		{
			E e=(E)currNode.e;
			currNode=currNode.next;
			return e;
		}

		@Override
		public void remove() 
		{
			
		}
		
	}
	static class Node<E>
	{
		private E e;
		private Node<E> next;
		Node(E e,Node<E> next)
		{
			this.e=e;
			this.next=next;
		}
		public E getE() 
		{
			return e;
		}
		public void setE(E e) 
		{
			this.e = e;
		}
		public Node<E> getNext() 
		{
			return next;
		}
		public void setNext(Node<E> next) 
		{
			this.next = next;
		}
		@Override
		public String toString() 
		{
			return e.toString();
		}
	}
	
	public Stack<E> sort(Stack<E> stack)
	{
		Stack<E> stacknew=new Stack<>();
		
		while(!stack.isEmpty())
		{
			E temp=stack.pop();
			while(!stacknew.isEmpty() && ((Comparable<E>)stacknew.top()).compareTo(temp)>0)
			{
				stacknew.push(stacknew.pop());
			}
			stacknew.push(temp);
		}
		return stacknew;
	}
}
