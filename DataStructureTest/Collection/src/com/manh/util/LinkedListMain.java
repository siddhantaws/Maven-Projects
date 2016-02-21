package com.manh.util;

import java.util.Iterator;

public class LinkedListMain 
{
	public static void main(String[] args) 
	{
		List<String> l=new LinkedList<>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		((LinkedList)l).reverseLinkedList();
		Iterator<String> iterator=l.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		/*	l.add("C");
		l.add("D");
		l.add("E");
		Iterator<String> iterator=l.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		//((LinkedList)l).reverseLinkedList();
		iterator=l.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		((LinkedList)l).printReverserOrder();
		((LinkedList)l).reversePair();
		Iterator<String> iterator=l.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}*/
	}
	
}
