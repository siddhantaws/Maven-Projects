package com.manh.search;

public class ArraysFindingOddNumberElement
{
	private int arrays[]={1,2,3,2,3,1,3};
	public static void main(String[] args) 
	{
		ArraysFindingOddNumberElement arraysOne=new ArraysFindingOddNumberElement();
		System.out.println(arraysOne.findingOddNumberElement(arraysOne.arrays));
	}
	
	public Integer findingOddNumberElement(int arrays[])
	{
		int X=0;
		for(int i=0;i<arrays.length;i++)
		{
			X^=arrays[i];
		}
		return X;
	}
}
