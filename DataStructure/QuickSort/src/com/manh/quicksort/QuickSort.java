package com.manh.quicksort;

public class QuickSort 
{
	
	private int arr[]={10,20,4,56,45,90,5};
	public int partition(int arr[],int start ,int end)
	{
		int pivot=arr[end];
		int pIndex=start;
		for(int i=start;i<end-1;i++)
		{
			if(arr[i]<pivot)
			{
				swap(i,pIndex);
				pIndex++;	
			}
		}
		swap(pIndex,end);
		return pIndex;
	}
	public void quickSort(int arr[],int start ,int end)
	{
		if(start<end)
		{
			int partionIndex=partition(arr, start , end);
			quickSort(arr,start,partionIndex-1);
			quickSort(arr,partionIndex+1,end);
		}
	}
	
	public void swap(int from ,int to)
	{
		int temp=arr[from];
		arr[from]=arr[to];
		arr[to]=temp;
	}
	public static void main(String[] args) 
	{
		QuickSort  quickSort=new QuickSort();
		quickSort.quickSort(quickSort.arr, 0, quickSort.arr.length-1);
	//	System.out.println(quickSort.partition(quickSort.arr, 0, quickSort.arr.length-1));
		for(int i:quickSort.arr)
		{
			System.out.println(i+"");
		}
	}
}
