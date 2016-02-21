package com.manh.test;

public class BinaryMinHeapMain 
{
	public static void main(String[] args) 
	{
		BinaryMinHeap<String> binaryMinHeap=new BinaryMinHeap<>();
		binaryMinHeap.add(10, "A");
		binaryMinHeap.add(7, "B");
		binaryMinHeap.add(9, "C");
		binaryMinHeap.add(15, "D");
		binaryMinHeap.add(4, "E");
		binaryMinHeap.add(20, "F");
		binaryMinHeap.add(18, "G");
	}
}
