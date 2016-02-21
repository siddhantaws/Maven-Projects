package com.manh.designpattern;

public class Square extends Shape 
{
	public Square()
	{
	   setType("Square");
	}
	
	@Override
	void draw() 
	{
		System.out.println("Inside Square::draw() method.");
	}

}
