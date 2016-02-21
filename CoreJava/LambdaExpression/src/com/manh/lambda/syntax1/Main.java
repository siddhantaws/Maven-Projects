package com.manh.lambda.syntax1;

public class Main {
	
	public static void main(String[] args) {

		// Set variables with lambda expressions
    Calculator multiply = (int x, int y) -> {return x * y;}; // No simplification
    Calculator divide = (x, y) -> {return x * y;};           // Type inference simplification
		int product = multiply.calculate(50, 10);
		int quotient = divide.calculate(50, 10);

		System.out.println("product = " + product + " quotient = " + quotient);
		
		// Pass lambda expression as arguments
		someMethod (multiply, divide);
		
		// Pass lambda expression as arguments
		anotherMethod((int x, int y) -> {return x * y;},   // No simplification
				          (x, y) -> {return x * y;});          // Type inference simplification
		
	}
	
	public static void someMethod(Calculator m, Calculator d){
		int product = m.calculate(60, 10);
		int quotient = d.calculate(60, 10);
		System.out.println("product = " + product + " quotient = " + quotient);
	}
	
	public static void anotherMethod(Calculator m, Calculator d){
		int product = m.calculate(70, 10);
		int quotient = d.calculate(70, 10);
		System.out.println("product = " + product + " quotient = " + quotient);
	}
}
