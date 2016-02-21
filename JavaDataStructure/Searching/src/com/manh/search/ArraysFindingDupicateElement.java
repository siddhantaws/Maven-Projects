package com.manh.search;

public class ArraysFindingDupicateElement 
{
	private int arrays[]={3, 2, 1, 2, 2, 3};
	public static void main(String[] args) 
	{
		ArraysFindingDupicateElement arraysOne=new ArraysFindingDupicateElement();
		arraysOne.findDuplicate(arraysOne.arrays);
	}
	
	public void findDuplicate(int arrays[])
	{
		/*for(int i=0;i<arrays.length;i++)
		{
			if(arrays[i]<0 || arrays[Math.abs(arrays[i])]<0)
			{
				return true;
			}else
				arrays[arrays[i]]=-arrays[arrays[i]];
		}
		return false;*/
		for(int i=0;i<arrays.length;i++)
		{
			if(arrays[Math.abs(arrays[i])]<0)
			{
				System.out.println("Duplicate Exists "+arrays[i]);
				return ;
			}else
			{
				arrays[arrays[i]]=-arrays[arrays[i]];
			}
		}
		
	}
}
