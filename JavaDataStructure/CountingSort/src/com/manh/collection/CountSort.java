package com.manh.collection;

public class CountSort
{
	private static int arrays[]={ 1,3,2,3,4,1,5,2,3};
	
	public static void countSort(int arrays[] ,int k,int newArrays[])
	{
		int tempArrays[]=new int[k];
		
		for(int i=0;i<tempArrays.length-1;i++)
			tempArrays[i]=0;
		
		for(int i=0;i<tempArrays.length-1;i++)
		{
			tempArrays[arrays[i]]=tempArrays[arrays[i]]+1;
		}
		
		for(int i=1;i<tempArrays.length-1;i++)
		{
			tempArrays[i]=tempArrays[i]+tempArrays[i-1];
		}
		
		
		for(int i=arrays.length-1;i>=0;i--)
		{
			newArrays[tempArrays[arrays[i]]]=arrays[i];
			tempArrays[arrays[i]]=tempArrays[arrays[i]]-1;
		}
		for(Integer i1:newArrays)
		{
			System.out.println(i1);
		}
	}
	public static void main(String[] args) 
	{
		int newArrays[]=new int[arrays.length];
		CountSort.countSort(arrays, 5+1, newArrays);
	}
}
