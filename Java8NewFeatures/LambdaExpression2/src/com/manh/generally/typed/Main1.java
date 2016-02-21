package com.manh.generally.typed;

import java.util.function.Supplier;

public class Main1 
{
	public static void main(String[] args) 
	{
		Supplier<String> s1=()-> "JPassion.com";
		printSupply(s1);
		
		Supplier<Integer> s2=()->10;
		printSupply(s2);
		
	}
	
	public static <T> void printSupply(Supplier<T> supplier)
	{
		System.out.println(supplier.get());
	}
}
