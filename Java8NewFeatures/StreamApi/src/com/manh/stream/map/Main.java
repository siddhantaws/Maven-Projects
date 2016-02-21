package com.manh.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main 
{
	public static void main(String[] args) 
	{
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Stream<Integer> stream=numbers.stream().filter(i->i>5).map(i-> i+5);
		stream.forEach(i-> System.out.println(i));
		
		Stream<String> stream2=Stream.of("Apple","Orange","Cherry").map(String::toUpperCase);
		stream2.forEach(s-> System.out.println(s));
		
	}
}
