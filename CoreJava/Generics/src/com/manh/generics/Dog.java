package com.manh.generics;

public class Dog extends Pet implements BarkBehaviour
{

	public Dog(String name) 
	{
		super(name);
	}
	
	public void display()
	{
		System.out.println("This is Dog "+getName());
	}

	@Override
	public void canBark() 
	{
		System.out.println("Dog can Bark");
	}
}
