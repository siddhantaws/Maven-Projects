package com.manh.collection;

import java.util.concurrent.BlockingQueue;

public class ArrayDequeMain 
{
	public static void main(String[] args) 
	{

		ArrayDeque<String> deque=new ArrayDeque<>();
		deque.add("A");
		deque.add("B");
		deque.add("C");
		deque.add("D");
		deque.addFirst("E");
		deque.addFirst("F");
		deque.addLast("G");
	}
}
