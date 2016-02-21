package com.manh.sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort 
{	
	public static void main(String[] args) 
	{
		List<Integer> integers=new ArrayList<>();
		integers.add(10);
		integers.add(5);
		integers.add(50);
		integers.add(44);
		integers.add(42);
		integers.add(60);
		integers.add(80);
		integers.add(66);
		new SelectionSort().selectionSort(integers);
	}
	
	public void selectionSort(List<Integer> integers)
	{
		Integer min=null;
		for(int i=0;i<integers.size()-1;i++)
		{
			int index=i;
			for(int j=i+1;j<integers.size();j++)
				if(integers.get(j) <integers.get(index))
					index=j;
			int smallestInt=integers.get(index);
			integers.set(index, integers.get(i));
			integers.set(i, smallestInt);
			
		}
		System.out.println(integers);
	}
}

