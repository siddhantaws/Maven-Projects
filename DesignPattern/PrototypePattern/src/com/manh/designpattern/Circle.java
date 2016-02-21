package com.manh.designpattern;

public class Circle extends Shape 
{
	public Circle()
	{
	   setType("Circle");
	}
	
	@Override
	void draw() 
	{
		System.out.println("Inside Circle::draw() method.");
	}

}
