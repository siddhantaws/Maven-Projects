package com.manh.staticref1;

public class Main 
{
	public static void main(String[] args) 
	{
		MyFunctionalInterface interface1=()->MyClass.existingStaticMethod();
		MyFunctionalInterface interface2=MyClass::existingStaticMethod;
		interface2.myCustomMethod();
	}
}
