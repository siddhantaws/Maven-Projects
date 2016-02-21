package com.manh.java8.annotation;

public class Person 
{
	@Hints(values={@Hint("hint1"), @Hint("hint2")})
	private int id;
	

	private String name;
}
