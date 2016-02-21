package com.manh.util;

import java.util.Iterator;

public class CircularLinkedListMain 
{
	public static void main(String[] args) 
	{
		List<String> l=new CircularLinkedList<>();
		l.add("A");
		l.add("B");
		l.add("C");
		Iterator<String> iterator=l.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println(((CircularLinkedList)l).circularLinkedListContainsLoop());
	}
}
