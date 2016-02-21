package com.manh.collection;

public class QuickSort<E extends Comparable> 
{
	private E[] arrays;
	
	public QuickSort(E[] arrays)
	{
		this.arrays=arrays;
	}

	public E[] getArrays() 
	{
		return arrays;
	}

	public void setArrays(E[] arrays) 
	{
		this.arrays = arrays;
	}
	
	protected void qucikSort(E[] arrays ,int start ,int end)
	{
		if(start<end)
		{
			int pIndex=getPivotIndex(arrays  ,start ,end);
			qucikSort( arrays , start ,pIndex-1);
			qucikSort( arrays ,pIndex+1 , end);
		}
		
	}
	
	public void qucikSort()
	{
		qucikSort(arrays  ,0 ,arrays.length-1);
	}
	public int getPivotIndex(E[] e ,int start ,int end)
	{
		E pivotElement=e[end];
		int pIndex=start;
		for(int i=start;i<e.length-1;i++)
		{
			if(e[i].compareTo(pivotElement)<0)
			{
				swap(i,pIndex);
				pIndex++;
			}
		}
		swap( pIndex , end);
		return pIndex;
	}
	
	protected void swap(int source,int dest)
	{
		E pivotElement=arrays[source];
		arrays[source]=arrays[dest];
		arrays[dest]=pivotElement;
	}
}	
