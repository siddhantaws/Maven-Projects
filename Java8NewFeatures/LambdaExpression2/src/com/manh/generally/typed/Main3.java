package com.manh.generally.typed;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main3 
{
	public static void main(String[] args) 
	{
		Function<String, String> f1=x -> x.toLowerCase();
		print(f1, "JPASSION.COM");
		
		Function<String, Integer> f2=x2->x2.length();
		print(f2, "JPassion.com");
		
		BiFunction<String, String, Integer> b1=(x,y)->x.length()+y.length();
		print(b1, "Siddhanta", "Pattnaik");
	}
	
	public static <T,R> void print(Function<T, R> function, T t)
	{
		System.out.println(function.apply(t));
	}
	
	public static <T, U, R> void print(BiFunction<T, U, R> b1, T t ,U u)
	{
		System.out.println(b1.apply(t,u));
	}
}
