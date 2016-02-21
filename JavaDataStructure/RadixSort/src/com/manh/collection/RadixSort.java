package com.manh.collection;

import java.util.LinkedList;

public class RadixSort {
	public static void main(String[] argv) 
	{
		int n = 5;
		int arr[] = { 1, 4, 2, 3, 5, 10, 8 };
		new RadixSort().radixSort(arr, 2);
	}
	
	public void radixSort(int arr[], int maxDigits){
        int exp = 1;//10^0;
        for(int i =0; i < maxDigits; i++)
        {
            LinkedList<Integer>  bucketList[] = new LinkedList[10];
            
            for(int k=0; k < 10; k++)
            {
                bucketList[k] = new LinkedList();
            }
            
            for(int j =0; j < arr.length; j++){
                int number = (arr[j]/exp)%10;
                bucketList[number].add(arr[j]);
            }
            exp *= 10;
            int index =0;
            for(int k=0; k < 10; k++){
                for(int num: bucketList[k]){
                    arr[index] = num;
                    index++;
                }
            }
        }
 
        System.out.println("Sorted numbers");
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] +", ");
        }
    }
}
