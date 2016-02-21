package com.manh.collection;

public class InsertionSort<E extends Comparable> 
{
	private E[] arrays; 
	
	
	public E[] getArrays() {
		return arrays;
	}
	public void setArrays(E[] arrays) {
		this.arrays = arrays;
	}
	
	public InsertionSort(E[] arrays)
	{
		this.arrays=arrays;
	}
	
	public void sort()
	{
		for(int i=1;i<arrays.length;i++)
		{
			int temp=i;
			E e=arrays[temp];
			while(temp>=0 && arrays[temp].compareTo(arrays[i])>0)
			{
				arrays[temp]=arrays[temp-1];
				temp=temp-1;
			}
			arrays[temp]=e;
		}
	}
}
