package com.manh.collection.main;

import java.util.Iterator;

import com.manh.collection.CircularLinkedList;
import com.manh.collection.List;

public class CircularListMain 
{
	public static void main(String[] args) 
	{
		List<String> list=new CircularLinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> iterator=list.iterator();
		if(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println(((CircularLinkedList<String>)list).isCircularLinkedList());
	}
}
