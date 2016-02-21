package com.manh.collection;

public class QuickSortMain 
{
	public static void main(String[] args) 
	{
		Integer arrsys[]={10 ,5, 2,20,9,50};
		QuickSort<Integer> quickSort=new QuickSort<>((Integer[])arrsys);
		quickSort.qucikSort();
		for(Integer inte:quickSort.getArrays())
		{
			System.out.println(inte);
		}
	}
}
