package com.manh.collection;

import java.util.Iterator;

public class CopyOnWriteArrayListMain
{
	public static void main(String[] args) 
	{
		List<String> list=new CopyOnWriteArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
