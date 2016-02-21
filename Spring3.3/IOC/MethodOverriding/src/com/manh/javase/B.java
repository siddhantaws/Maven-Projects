package com.manh.javase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class B extends A 
{
	void m1(){
		System.out.println("B-m1()");
	}
	void m3(String a){
		System.out.println("A-m3()");
	}
	/*private void m4() {
		System.out.println("A-m4()");
	}
	 void m5() {
		System.out.println("A-m5()");
	}*/
	protected void m6() {
		System.out.println("A-m6()");
	}
	public void m7() {
		System.out.println("A-m7()");
	}
	/*static void m8() {
		System.out.println("A-m8()");
	}*/
	static void m9() {
		System.out.println("A-m9()");
	}
	void m10(){
		System.out.println("A-m10()");
	}
	void m13()throws ArithmeticException
	{
		
	}
}
