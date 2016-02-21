package com.manh.collection;

public enum Pizza 
{
	Samll(50),Medium(70),Large(100);
	
	private int value;
	Pizza(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
	
}
