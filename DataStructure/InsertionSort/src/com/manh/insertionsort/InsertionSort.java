package com.manh.insertionsort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort 
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
		new InsertionSort().insertionSort(integers);
	}
	public void insertionSort(List<Integer> integers)
	{
		int min;
		for(int i=1;i<integers.size();i++)
		{
			for(int j=i;j>0;j--)
			{
				if(integers.get(j) <integers.get(j-1))
				{
					min=integers.get(j);
					integers.set(j, integers.get(j-1));
					integers.set(j-1, min);
				}
			}
		}
		System.out.println(integers);
	}
}
