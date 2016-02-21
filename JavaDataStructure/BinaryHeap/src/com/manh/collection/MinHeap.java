package com.manh.collection;

import java.util.PriorityQueue;

public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= size / 2 && pos <= size)
			return true;
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	public void insert(int element) {
		Heap[++size] = element;
		int current = size;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
					+ Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}
	
	public void minHepify(int pos)
	{
		if(!isLeaf(pos))
		{
			if( (Heap[pos] > Heap[rightChild(pos)]) || ( Heap[pos] > Heap[leftChild(pos)]) )
			{
				if( Heap[leftChild(pos)] > Heap[rightChild(pos)])
				{
					swap(pos, rightChild(pos));
					minHepify(rightChild(pos));
				}else
				{
					swap(pos, leftChild(pos));
					minHepify(leftChild(pos));
				}
			}
		}
	}
	
	public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
        	minHepify(pos);
        }
    }
	public static void main(String...arg)
    {
		PriorityQueue priorityQueue=new PriorityQueue<>();
        System.out.println("The Max Heap is ");
        MinHeap maxHeap = new MinHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        //maxHeap.maxHeap();
        maxHeap.print();
      
    }	
}
