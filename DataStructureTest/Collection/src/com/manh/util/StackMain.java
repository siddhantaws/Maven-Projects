package com.manh.util;

import java.util.Iterator;

public class StackMain 
{
	public static void main(String[] args) 
	{
		Stack<String> stack=new Stack<>();
		stack.push("F");
		stack.push("C");
		stack.push("A");
		stack.push("B");
		Iterator<String> iterator=stack.sort(stack).iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+",");
		}
	}
}
