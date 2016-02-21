package com.manh.collection;

public class Heap<E extends Comparable> 
{
	private E[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public Heap(int maxsize) 
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap =(E[]) new Object[this.maxsize + 1];
	}

	private int parent(int pos) 
	{
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) 
	{
		E tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}
	
	public void insertAsMaxHeap(E element) 
	{
		Heap[++size] = element;
		int current = size;

		while (Heap[current].compareTo(Heap[parent(current)]) >0) 
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public void maxHepify(int pos)
	{
		if(!isLeaf(pos))
		{
			if( (Heap[pos].compareTo( Heap[rightChild(pos)])>0 ) || (Heap[pos].compareTo( Heap[leftChild(pos)])>0 ) )
			{
				if( Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) >0 )
				{
					swap(pos, rightChild(pos));
					maxHepify(rightChild(pos));
				}else
				{
					swap(pos, leftChild(pos));
					maxHepify(leftChild(pos));
				}
			}
		}
	}
	
	public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
        	maxHepify(pos);
        }
    }
	
	public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }
	
	public static void main(String...arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
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
