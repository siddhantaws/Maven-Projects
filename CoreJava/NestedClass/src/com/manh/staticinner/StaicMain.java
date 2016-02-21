package com.manh.staticinner;

public class StaicMain 
{
	public static void main(String[] args) 
	{
		System.out.println(A.B.bn);
		//System.out.println(A.B.mn);
		A.B ab=new A.B();
		ab.show();
		A obj=new A();
	}
}
