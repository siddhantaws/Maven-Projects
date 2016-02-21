package com.manh.generics;

public class Pet 
{
	private String name;
	public Pet(String name)
	{
		this.name=name;
	}
	public void display()
	{
		System.out.println("This is pet "+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
