package com.manh.stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main 
{
	public static void main(String[] args) 
	{
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		Stream<Integer> streams=numbers.stream().filter(p-> p>5);
		streams.forEach(i -> System.out.println(i));
	}
}
