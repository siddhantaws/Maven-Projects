package com.manh.collection;

public class InsertionSortMain 
{
	public static void main(String[] args) 
	{
		Integer arrays[]={5,10,20,11,16,7,9,12};
		InsertionSort<Integer> insertionSort=new InsertionSort<>(arrays);
		insertionSort.sort();
		for(Integer in:insertionSort.getArrays())
		{
			System.out.println(in);
		}
	}
}
