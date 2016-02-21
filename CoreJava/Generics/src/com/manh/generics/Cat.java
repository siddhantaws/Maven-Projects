package com.manh.generics;

public class Cat extends Pet implements SweekBehaviour
{

	public Cat(String name) 
	{
		super(name);	
	}

	public void display()
	{
		System.out.println("This is Cat "+getName());
	}

	@Override
	public void sweek() 
	{
		System.out.println("Cat can sweek");
	}
}
