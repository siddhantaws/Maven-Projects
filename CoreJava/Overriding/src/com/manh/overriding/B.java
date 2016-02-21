package com.manh.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

public class B extends A 
{
	void m1()
	{
		System.out.println("B->m1");;	
	}
	
	/*static void m2()
	{
		System.out.println("B->m2");;	
	}*/
	
	protected final void m4()
	{
		System.out.println("B->m4");;
	}
	
	public void m5(){
		
	}
	protected void m6(){
		
	}
	
	protected void m7(){
		
	}
	//static void m8(){}
	
	static void m9()
	{
		System.out.println("B->m9");;
	}
	void m10(){System.out.println("B->m10");;}
	
	/*final void m11(){
		System.out.println("B->11");
	}*/
	
	private final void m12(){System.out.println("B->m12");}
	
	void m13(){System.out.println("B->m13");}
	
	final void m14(){
		
	}
	/*void m20()throws IOException
	{
		
	}*/
	void m21()throws RuntimeException
	{
		
	}
	
	void m15()throws RuntimeException
	{
		
	}
	void m16()throws ArrayIndexOutOfBoundsException
	{
		
	}
	void m17()throws FileNotFoundException{
		
	}
	void m18()throws OutOfMemoryError
	{
		
	}
	void m19()throws ArrayIndexOutOfBoundsException
	{
		
	}
}
