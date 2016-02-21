package com.manh.stream.iteration;

import java.util.Arrays;
import java.util.List;

public class StreamIteration 
{
	public static void main(String[] args) 
	{
		 List<Integer> list = Arrays.asList(3,14,11);
		 System.out.println(sumStream(list));
	}
	
	public static int sumStream(List<Integer> integers)
	{
		return integers.stream().filter(i-> i>3).mapToInt(i->i).sum();
	}
}
