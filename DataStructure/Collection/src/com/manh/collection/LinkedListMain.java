package com.manh.collection;

public class LinkedListMain 
{
	public static void main(String[] args) 
	{
		LinkedList<String> lists=new LinkedList<>();
		lists.add("A");
		lists.add("B");
		lists.add("C");
		lists.add("D");
		lists.addFirst("F");
		lists.addLast("G");
		lists.removeFirst();
	}
}
