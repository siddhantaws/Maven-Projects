package com.manh.collection;

import java.util.Iterator;

import com.manh.collection.LinkedList.LinkedItr;
import com.manh.collection.LinkedList.Node;


public class CircularLinkedList<E> implements List<E> 
{
	 private int size=0;
	
	 static Node first=null;
	 
	 static Node last=null;
	
	static class Node<E>
	{
		E e;
		Node<E> next;
		Node(E e)
		{
			this.e=e;
		} 		
	}
	@Override
	public E add(E e) 
	{
		return createNode(e).e;
	}
	
	protected Node<E> createNode(E e)
	{
		Node<E> node=new Node<E>(e);
		if(first==null)
			first=last=node;
		last.next=last=node;
		last.next=first;
		return node;
	}
	
	@Override
	public E removeNode(E e) 
	{
		deleteNode(e);
		return e;
	}
	protected boolean deleteNode(E e)
	{
		Node prevNode=null;
		for(Node node=first;(node!=first || node!=null );node=node.next)
		{
			if(node.e.equals(e))
			{
				unlink(node,prevNode);
				return true;
			}
			prevNode=node;
		}
		return false;
	}
	protected void unlink(Node node,Node prevNode)
	{
		if(prevNode==null)
			first=null;
		else
		{
			prevNode.next=node.next;
			node=null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedItr<>() ;
	}

	@Override
	public void removeFirst() 
	{
		Node<E> node=(Node<E>)first;
		first=first.next;
		node=null;
	}

	@Override
	public E add(E e, int i) 
	{
		Node<E> prevNode=null;
		int j=0;
		for(Node node=first;node!=null ;node=node.next)
		{
			prevNode=node;
			if(++j==i)
				break;
		}
		addLink(e,prevNode);
		return null;
	}
	
	protected void addLink(E e,Node<E> prevNode)
	{
		Node<E> node =new Node<E>(e);
		node.next=prevNode.next;
		prevNode.next=node;
	}
	

	static class CircularItr<E> implements Iterator<E>
	{
		Node<E> head;
		CircularItr()
		{
			
		}
		
		@Override
		public boolean hasNext() 
		{
			if(head==null)
				head=first;
			return head!=first &&  head!=null;
		}

		@Override
		public E next() 
		{
			E e=head.e;
			head=head.next;
			return e;
		}

		@Override
		public void remove()
		{
			//removeNode((E)head.e); 
		}
		
	}
	public boolean isCircularLinkedList()
	{
		Node<E> fast=first, slow=first;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow= slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				return true;
			}
		}
		return false;
	}
	
	
}
