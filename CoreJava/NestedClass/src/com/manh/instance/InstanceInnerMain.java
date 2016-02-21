package com.manh.instance;

public class InstanceInnerMain 
{
	public static void main(String[] args) 
	{
		new A().new B();
		A obj=new A();
		A.B ab=new A().new B();
		//ab=new A.B();
		ab=obj.new B();
	}
}
