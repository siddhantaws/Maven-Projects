package com.manh.generics;

public class SimpleGenericTwoParamsMain 
{
	public static void main(String[] args) 
	{
		SimpleGenericTwoParams<String, Boolean> genericTwoParams=new SimpleGenericTwoParams<String, Boolean>("A", Boolean.FALSE);
		genericTwoParams.printTypes();		
	}
}
