package com.manh.staticref3;

public class Main 
{
	public static void main(String[] args) 
	{
		yourMethod((name,age)->MyClass.existingStaticMethod(name));
	}
	
	public static void yourMethod(MyFunctionalInterface  interface1)
	{
		interface1.mySingleAbstractMethod("Siddhanta", 29);
	}
}
