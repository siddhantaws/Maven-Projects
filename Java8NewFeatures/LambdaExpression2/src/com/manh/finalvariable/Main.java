package com.manh.finalvariable;

public class Main 
{
	public static void main(String[] args) 
	{
		int myInt = 100;

        // Set variables with lambda expressions
        Calculator multiply = (int x, int y) -> { return x * y * myInt;}; 
        Calculator divide = (x, y) -> {return x * y;};           
        int product = multiply.calculate(50, 10);
        int quotient = divide.calculate(50, 10);

        System.out.println("product = " + product + " quotient = " + quotient);
        
	}
	@FunctionalInterface
	interface Calculator
	{
		public int calculate(int x,int y);
	}
}
