package com.manh.search;

public class ArraysFindingMaxRepeatElement 
{
	private int arrays[]={1, 2, 3, 1,};
	public static void main(String[] args) 
	{
		ArraysFindingMaxRepeatElement arraysOne=new ArraysFindingMaxRepeatElement();
		System.out.println(arraysOne.findingMaxRepeatElement(arraysOne.arrays,arraysOne.arrays.length-1));
	}
	public int findingMaxRepeatElement (int arrays[],int n)
	{
		int max=0 ,maxindex=0;;
		for(int i=0;i<n;i++)
			arrays[arrays[i]%n]+=n;
		for(int i=0;i<n;i++)
		{
			if(arrays[i]/n>max)
			{
				max=arrays[i]/n;
				maxindex=i;
			}
		}
		return maxindex;
	}
}
