package com.manh.collection.main;

import java.util.ArrayList;
import java.util.Iterator;

import com.manh.collection.LinkedList;
import com.manh.collection.List;

public class LinlkedListMain 
{
	public static void main(String[] args) 
	{
		List<String> list=new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		/*Iterator<String> iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		list.add("F" ,3);
		System.out.println("-----");
		iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println(((LinkedList)list).findNthElementFromLast(2));
		System.out.println("-----");
		((LinkedList<String>)list).reverseLinkedList();
		iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		((LinkedList)list).reverseAPair();
		Iterator<String> iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		((LinkedList)list).reverseAportionOfLinkedList(4);
		Iterator<String> iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}*/
		((LinkedList)list).swapTwoPosition("B", "E");
		Iterator<String> iterator= list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
