package com.manh.search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysFindingTwoElementWithSum 
{
	private int arrays[]={1, 8, 7, 10, 2, 5, 9};
	public static void main(String[] args) 
	{
		ArraysFindingTwoElementWithSum arraysFindingTwoElementWithSum=new ArraysFindingTwoElementWithSum();
		arraysFindingTwoElementWithSum.findElementTwo(arraysFindingTwoElementWithSum.arrays ,15);
	}
	public void findElementOne(int arrays[],int k)
	{
		
	}
	public void findElementTwo(int arrays[],int k)
	{
		Set<Integer> integers=new HashSet<>();
		for(Integer integer:arrays)
		{
			integers.add(integer);
		}
		
		for(Integer integer:integers)
		{
				if(integers.contains(k-integer))
					System.out.println(integer+"\t"+(k-integer));
		}

	}
}
