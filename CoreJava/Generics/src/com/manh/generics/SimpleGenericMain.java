package com.manh.generics;

public class SimpleGenericMain 
{
	public static void main(String[] args) 
	{
		SimpleGeneric<String> generic1=new SimpleGeneric<String>("A");
		SimpleGeneric<Boolean> generic2=new SimpleGeneric<Boolean>(Boolean.FALSE);
		generic1.printType();
		generic2.printType();
	}
}
