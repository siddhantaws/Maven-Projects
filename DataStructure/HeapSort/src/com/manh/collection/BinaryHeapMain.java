package com.manh.collection;

public class BinaryHeapMain 
{
	public static void main(String[] args) 
	{
		BinaryHeap binaryHeap=new BinaryHeap(10);
		binaryHeap.insertAtAcending(10);
		binaryHeap.insertAtAcending(7);
		binaryHeap.insertAtAcending(2);
		binaryHeap.insertAtAcending(5);
		binaryHeap.insertAtAcending(4);
		binaryHeap.insertAtAcending(1);
		binaryHeap.insertAtAcending(8);
		binaryHeap.printHeap();
	}
}
