package com.manh.stack;

import com.manh.collection.Stack;

public class PostfixEvaluation 
{
	public int calculate(String s)  
	{  
	     int n,r=0;  
	     n=s.length();  
	     Stack<Integer> a=new Stack(50);  
	     for(int i=0;i<n;i++)  
	     {  
	       char ch=s.charAt(i);  
	       if(ch>='0'&&ch<='9')  
	         a.push((int)(ch-'0'));  
	       else  
	       {  
	         int x=a.pop();  
	         int y=a.pop();  
	         switch(ch)  
	         {  
	           case '+':r=x+y;  
	              break;  
	           case '-':r=y-x;  
	              break;  
	           case '*':r=x*y;  
	              break;  
	           case '/':r=y/x;  
	              break;  
	           default:r=0;  
	         }  
	         a.push(r);  
	       }  
	     }  
	     r=a.pop();  
	     return(r);  
	} 
	
	public static void main(String[] args) 
	{
		System.out.println(new PostfixEvaluation ().calculate("123*+4-"));
	}
}
