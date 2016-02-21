package com.manh.stream.laziness;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lazyness1 
{
	public static void main(String[] args) 
	{
		List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12);
		 List<Integer> newNumbersList = 
		            numbersList.stream()
		                   .filter(n -> {                         // intermediate operation
		                            System.out.println("filtering " + n); 
		                            return n % 3 == 0;
		                          })
		                   .map(n -> {                         // intermediate operation
		                            System.out.println("mapping " + n);
		                            return n * n;
		                          })
		                   .limit(2)                                // intermediate operation
		                   .collect(Collectors.toList()); // terminal operation
	System.out.println(newNumbersList);	 
	}
}
