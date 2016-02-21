package com.manh.lambda;

public class Main {
   
    public static void main(String[] args) {

        /*// Set variables with lambda expressions
        Calculator multiply = (x, y) -> x * y;
        Calculator divide = (x, y) -> x / y;
        int product = multiply.calculate(50, 10);
        int quotient = divide.calculate(50, 10);

        System.out.println("product = " + product + " quotient = " + quotient);
       
        // Pass lambda expression as arguments
        someMethod (multiply, divide);
       
        // Pass lambda expression as arguments
        anotherMethod((x, y) -> x * y, (x, y) -> x / y);*/
    	Calculator multiply =(p,q)-> p*q;
    	Calculator division= (p,q)->p/q;
    	multiply.calculate(10, 20);
    	division.calculate(10, 2);
    	someMethod(multiply, division);
    	anotherMethod((x,y)->x*y ,(x,y)->x/y);
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