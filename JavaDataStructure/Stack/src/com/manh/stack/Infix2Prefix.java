package com.manh.stack;

import com.manh.collection.Stack;

public class Infix2Prefix 
{
	public String inToPre(String infixStrings)
	{
		Stack<Character> stack = new Stack(50);
        String prefix = "";
        for(int i=infixStrings.length()-1;i>=0;i--){
            char c = infixStrings.charAt(i);
            if(Character.isLetter(c)){
                prefix = ((Character)c).toString() + prefix;
            }
            else if(c == '('){
                prefix = ((Character)stack.pop()).toString() + prefix;
            }
            else if(c == ')'){
                continue;
            }
            else{
                stack.push(c);
            }
        }
        return prefix;
	}
	public static void main(String[] args) 
	{
		System.out.println(new Infix2Prefix().inToPre("((a+b)*(z+x))"));
	}
}
