package com.manh.stack;

import com.manh.collection.Stack;

public class Infix2Postfix 
{
	
	private Stack<Character> stack;
	private Character currChar;
	private String prefixString=new String();
	public Infix2Postfix()
	{
		stack=new Stack<>(100);
	}
	public String inToPost(String infixStrings)
	{
		String postfixString = " ";
		for(int i=0;i<infixStrings.length();i++)
		{
			Character chValue=infixStrings.charAt(i);
			switch(chValue)
			{
				case '(' :
					stack.push(chValue);
					break ;
				case ')' :
					currChar= stack.peek();
					while(!currChar.equals('(') && !stack.isEmpty())
					{
						prefixString=prefixString+currChar;
						stack.pop();
						currChar= stack.peek();
					}
					stack.pop();
					break;
				case '+':
				case '-':
					if(stack.isEmpty())
					{
						stack.push(chValue);
					}	
					else
					{
						currChar= stack.peek();
						while( chValue.equals('*') || chValue.equals('/'))
						{
							stack.pop();
							prefixString=prefixString+currChar;
						}
						stack.push(chValue);
					}
					break ;
				case '*':
				case '/':
					if(stack.isEmpty())
					{
						stack.push(chValue);
					}	
					else
					{
						currChar= stack.peek();
						stack.push(chValue);
					}
				break ;
				default :
						prefixString=prefixString+chValue;
			}
		}
		while(!stack.isEmpty())
		{
			prefixString=prefixString+stack.pop();
		}
		return prefixString;
	}
	public static void main(String[] args) 
	{
		System.out.println(new Infix2Postfix().inToPost("(1+2)*(3+4)"));
		
	}
}
