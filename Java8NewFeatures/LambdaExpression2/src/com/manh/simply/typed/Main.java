package com.manh.simply.typed;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;

public class Main 
{
	public static void main(String[] args) 
	{
		IntPredicate function1 = x -> x < 10;
        boolean resultBoolean = function1.test(5);
        System.out.println(resultBoolean);
        
        LongPredicate function2 = x -> x > 10;
        resultBoolean = function2.test(20L);
        System.out.println(resultBoolean);
        
        LongUnaryOperator longUnaryOperator=x-> x*10;
        long l1=longUnaryOperator.applyAsLong(20L);
        System.out.println(l1);
        
        DoubleBinaryOperator binaryOperator= (x,y)-> x+y;
        double resultDouble  =binaryOperator.applyAsDouble(20, 25);
        
	}
}
