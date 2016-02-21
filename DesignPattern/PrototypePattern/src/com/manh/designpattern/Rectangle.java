package com.manh.designpattern;

public class Rectangle extends Shape 
{
	public Rectangle()
	{
	   setType("Rectangle");
	}
	
	@Override
	void draw() 
	{
		System.out.println("Inside Rectangle::draw() method.");
	}

}
