package com.manh.collection;

public class StackMain 
{
	public static void main(String[] args) 
	{
		Stack<String> stack=new Stack<>(2);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.reverseStack();
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		/*stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.reverseStack();
		while(stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		int arrys[]={100, 80, 60, 70, 60, 75, 85};
		System.out.println(stack.findingSpans(arrys));;*/
		
	}
}
