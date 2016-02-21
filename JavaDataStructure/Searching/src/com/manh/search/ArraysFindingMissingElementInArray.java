package com.manh.search;

public class ArraysFindingMissingElementInArray 
{
	private int arrays[]={1, 2, 4, 6, 3, 7, 8};
	public static void main(String[] args) 
	{
		ArraysFindingMissingElementInArray arraysOne=new ArraysFindingMissingElementInArray();
		System.out.println(arraysOne.findingMissingElementInArray (arraysOne.arrays));
		//System.out.println(15^30);
	}
	public int findingMissingElementInArray(int arrays[])
	{
		int X=0,Y=0 ;
		for(int i=0;i<arrays.length;i++)
		{
			X ^=arrays[i];
		}
		for(int i=1;i<=arrays.length+1;i++)
		{
			Y ^=i;
		}
		return X^Y;
	}
}
