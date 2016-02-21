package com.manh.collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

import com.manh.collection.CircularLinkedList.Node;

public class LinkedList<E> implements List<E> 
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
		@Override
		public String toString() 
		{
			return e.toString();
		}
	}
	
	static class LinkedItr<E> implements Iterator<E>
	{
		Node<E> head;
		LinkedItr()
		{
			head=first;
		}
		
		@Override
		public boolean hasNext() 
		{
			return head!=null;
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
		for(Node node=first;node!=null ;node=node.next)
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
	
	public E findNthElementFromLast(int n)
	{
		Node<E> pTemp=first;
		Node<E> nthEle=null;
		for(int i=1 ;i<n;i++)
		{
			if(pTemp.next!=null)
				pTemp=pTemp.next;
		}
		
		while(pTemp!=null)
		{
			if(nthEle==null)
				nthEle=first;
			else
				nthEle=nthEle.next;
			pTemp=pTemp.next;
		}
		return nthEle.e;
	}
	public void reverseLinkedList()
	{
		Node<E> nextNode=first,temp=null;
		
		do{
			nextNode=first.next;
			first.next=temp;
			temp=first;
			if(nextNode!=null)
				first=nextNode;
		}while(first!=null && nextNode!=null);
	}
	
	public void reverseAPair()
	{
		first=reverseAPair(first);
	}
	
	protected Node<E> reverseAPair(Node<E> node)
	{
		Node<E> temp=null;
		if(node==null || node.next==null)
			return node;
		else 
		{
			temp=node.next;
			node.next=temp.next;
			temp.next=node;
			node=temp;
			node.next.next=reverseAPair(node.next.next);
		}
		return node;
		
	}
	public void reverseAportionOfLinkedList(int n)
	{
		first=reverseAportionOfLinkedList(getKPlus1Node(n),first);
	}
	protected Node<E> getKPlus1Node(int n)
	{
		int i=0;
		for(Node<E> node=first;node!=null;node=node.next)
		{
			if(i++==n)
				return node;
		}
		return null;
	}
	protected Node<E> reverseAportionOfLinkedList(Node<E> kPlusOneNode,Node<E> head)
	{
		if(head!=null && head.next!=kPlusOneNode)
		{
			reverseAportionOfLinkedList(kPlusOneNode,head.next);
			Node<E> nextNode=head.next;
			nextNode.next=head;
			head.next=kPlusOneNode;
			return nextNode;
		}	
		return head;
	}
	public void swapTwoPosition(E a ,E b)
	{
		Node<E> currX=first,prevX=null,currY=null,prevY=null;
		while(!currX.e.equals(a))
		{
			prevX=currX;
			currX=currX.next;
			
		}
		currY=currX;
		while(!currY.e.equals(b))
		{
			prevY=currY;
			currY=currY.next;
		}
		prevX.next=currY;
		prevY.next=currX;
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
}
