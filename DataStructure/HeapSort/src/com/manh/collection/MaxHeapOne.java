package com.manh.collection;

public class MaxHeapOne {
	private int array[];
	private int size = 0;;

	public MaxHeapOne()
	{
		array=new int[10];
	}
	
	public int parent(int pos) {
		return pos / 2;
	}

	public void swap(int from, int to) {
		array[from] = array[from] + array[to];
		array[to] = array[from] - array[to];
		array[from] = array[from] - array[to];
	}

	public void insert(int element) {
		array[++size] = element;
		int current = size;

		while (array[current] > array[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public static void main(String[] args) 
	{
		MaxHeapOne maxHeap=new MaxHeapOne();
		maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
	}

	/** Function to print heap **/

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + array[i] + " LEFT CHILD : "
					+ array[2 * i] + " RIGHT CHILD :" + array[2 * i + 1]);
			System.out.println();
		}
	}

}
