package com.manh.overriding;

import java.io.IOException;

public class A 
{
	void m1(){
	System.out.println("A->m1");;	
	}
	
	void m2()
	{
		System.out.println("A->m2");;	
	}
	void m3(int ab){}
	
	protected void m4(){
		System.out.println("A->m4");;
	}
	
	protected void m5(){}
	
	protected void m6(){}
	
	protected void m7(){}
	void m8(){}
	
	static void m9(){		System.out.println("A->m9");;}
	
	private static void m10(){System.out.println("A->m10");;}
	
	final void m11(){}
	
	private final void m12(){}
	
	private final void m13(){}
	
	void m14(){}
	
	void m15()throws IOException{}
	
	void m16()throws IOException{}
	
	void m17()throws IOException{}
	
	void m18()throws IOException{}
	
	void m19()throws Exception{}
	
	void m20(){}
	
	void m21(){}
}
