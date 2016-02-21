package com.manh.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class CircularLinkedList<E> extends LinkedList<E> 
{
	private int size;
	
	private int modCount;
	
	private Node<E> last;


	@Override
	public void addLast(E e) 
	{
		Node<E> nodeL=last;
		Node<E> currNode=new Node<E>(e, null, nodeL);
		if(nodeL==null)
		{
			first=last=currNode;
			currNode.prev=currNode;
			currNode.next=currNode;
		}
		else
		{
			first.prev=last=last.next=currNode;
			last.next=first;
		}
		size++;
		modCount++;
	}
	
	@Override
	public Iterator<E> iterator() 
	{
		return new CirItr();
	}
	
	class CirItr<E> extends Itr<E>
	{
		private Node<E> startNode;
		
		@Override
		public boolean hasNext() 
		{
			if(currNode==null)
				return false;
			if(startNode==null)
			{
				startNode=currNode;
				return true;
			}	
			return !(startNode==currNode);
		}	
	}
	public boolean circularLinkedListContainsLoop()
	{
		Node<E> slowPtr=first;
		Node<E> fastPtr=first;
		while(fastPtr.next!=null && fastPtr.next.next!=null)
		{
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next.next;
			if(slowPtr==fastPtr)
				return true;
		}
		return false;
	}
}
