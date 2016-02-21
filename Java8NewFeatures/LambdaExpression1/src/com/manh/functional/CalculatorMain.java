package com.manh.functional;

public class CalculatorMain 
{
	public static void main(String[] args) 
	{
		Calculator c1=(x,y)->x*y;
		Calculator c2=(x,y)->x/y;
		calculateOne(c1, c2);
	}
	public static void calculateOne(Calculator c1,Calculator c2)
	{
		System.out.println("Total Calculation :" + c1.calculate(60, 10) * c2.calculate(60, 10));
	}
}
