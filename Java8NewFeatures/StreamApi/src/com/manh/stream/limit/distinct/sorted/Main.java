package com.manh.stream.limit.distinct.sorted;

import java.util.Arrays;
import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 3, 5, 5, 6, 7, 8);
		numbers.stream().distinct().sorted().limit(4).forEach(i-> System.out.println(i));
	}
}
