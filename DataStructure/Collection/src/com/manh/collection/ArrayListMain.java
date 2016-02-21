package com.manh.collection;

import java.util.Iterator;

public class ArrayListMain 
{
	public static void main(String[] args) 
	{
		List<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		//list.remove("B");
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext())
		{
			String element=iterator.next();
			System.out.println(element);
		}
	}
}
