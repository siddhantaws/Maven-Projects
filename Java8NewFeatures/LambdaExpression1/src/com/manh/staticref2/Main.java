package com.manh.staticref2;

public class Main 
{
	public static void main(String[] args) 
	{
		MyFunctionalInterface interface1=(name ,age )-> MyClass.existingStaticMethod(name);
		interface1.mySingleAbstractMethod("Siddhanta", 25);
		MyFunctionalInterface interface2=MyClass::existingStaticMethod;
		interface2.mySingleAbstractMethod("Siddhanta", 26);
		
	}
}
