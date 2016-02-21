package com.manh.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeMap<K, V> {

	protected int size = 0;

	protected Entry<K, V> root;

	public void put(K k,V v )
	{
		++size;
		Entry<K, V> entry=new Entry<K, V>(k, null, null, v);
		addNode(entry);
	}
	
	public int size()
	{
		return size(root);
	}
	
	protected int size(Entry<K, V> root)
	{
		if(root==null)
			return 0;
		else 
			return size(root.getLeft())+1+size(root.getRight());
	}
	
	protected void addNode(Entry<K, V> entry)
	{
		if(root==null)
		{
			root=entry;
		}else
		{
			Entry<K, V> current=root;
			Entry<K, V> parent;
			while(true)
			{
				parent=current;
				if(((Comparable<K>)current.getK()).compareTo(entry.getK())>0)
				{
					current=current.getLeft();
					if(current==null)
					{
						parent.setLeft(entry);
						return ;
					}
				}else
				{
					current=current.getRight();
					if(current==null)
					{
						parent.setRight(entry);
						return ;
					}
				}
			}
		}
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}

	public Entry<K, V> getRoot() 
	{
		return root;
	}

	public void setHead(Entry<K, V> root) 
	{
		this.root = root;
	}

	static class Entry<K, V> 
	{
		K k;
		Entry<K, V> left;
		Entry<K, V> right;
		Entry<K, V> nextSibling;
		int height =0;
		
		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Entry<K, V> getNextSibling() {
			return nextSibling;
		}

		public void setNextSibling(Entry<K, V> nextSibling) {
			this.nextSibling = nextSibling;
		}

		V v;

		public Entry(K k, Entry<K, V> left, Entry<K, V> right, V v) {
			super();
			this.k = k;
			this.left = left;
			this.right = right;
			this.v = v;
		}

		public K getK() {
			return k;
		}

		public void setK(K k) {
			this.k = k;
		}

		public Entry<K, V> getLeft() {
			return left;
		}

		public void setLeft(Entry<K, V> left) {
			this.left = left;
		}

		public Entry<K, V> getRight() {
			return right;
		}

		public void setRight(Entry<K, V> right) {
			this.right = right;
		}

		public V getV() {
			return v;
		}

		public void setV(V v) {
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer(k.toString());
			if (getLeft() != null)
				buffer.append("Left ->" + getLeft().k);
			if (getRight() != null)
				buffer.append("Right ->" + getRight().k);
			return buffer.toString();
		}
	}
	public void deleteBinaryTree()
	{
		deleteBinaryTree(root);
	}
	protected void deleteBinaryTree(Entry root)
	{
		if(root==null)
			return ;
		deleteBinaryTree(root.getLeft());
		deleteBinaryTree(root.getRight());
		root=null;
	}
	
	public int heightOfTree(Entry<K, V> root)
	{
		int leftHeight ,rightHeight;
		if(root==null)
			return 0;
		leftHeight=heightOfTree(root.getLeft());
		rightHeight=heightOfTree(root.getRight());
		if(leftHeight>rightHeight)
			return leftHeight+1;
		else
			return rightHeight+1;
	}
	
	public K findDeepestNode()
	{
		return findDeepestNode(getRoot());
	}
	protected K findDeepestNode(Entry entry)
	{
		Queue<Entry> queue=new ArrayDeque<>();
		K k=null;
		queue.add(entry);
		while(!queue.isEmpty())
		{
			Entry entry2=queue.poll();
			if(entry2.getLeft()!=null)
				queue.add(entry2.getLeft());
			if(entry2.getRight()!=null)
				queue.add(entry2.getRight());
			k=(K) entry2.getK();
		}
		return k;
	}
	public int findFullNodes(Entry<K, V> entry) 
	{
		int count =0;
		Queue<Entry<K, V>> entries=new ArrayDeque<TreeMap.Entry<K,V>>();
		if(getRoot()==null)
			return 0;
		entries.add(getRoot());
		while(!entries.isEmpty())
		{
			Entry<K, V> entry2=entries.poll();
			if(entry2.getLeft()!=null  && entry2.getRight()!=null)
				++count;
			if(entry2.getLeft()!=null )
				entries.add(entry2.getLeft());
			if(entry2.getRight()!=null )
				entries.add(entry2.getRight());
		}
		return count;
	}
	public int findHalfNodes(Entry<K, V> entry) 
	{
		int count =0;
		Queue<Entry<K, V>> entries=new ArrayDeque<TreeMap.Entry<K,V>>();
		if(getRoot()==null)
			return 0;
		entries.add(getRoot());
		while(!entries.isEmpty())
		{
			Entry<K, V> entry2=entries.poll();
			if(entry2.getLeft()==null  || entry2.getRight()==null)
				++count;
			if(entry2.getLeft()!=null )
				entries.add(entry2.getLeft());
			if(entry2.getRight()!=null )
				entries.add(entry2.getRight());
		}
		return count;
	}
	@Override
	public boolean equals(Object obj) 
	{
		TreeMap map=(TreeMap)obj;
		return equals(getRoot(), map.getRoot());
	}
	protected boolean equals(Entry<K, V> first,Entry<K, V> second)
	{
		if(first==null && second==null)
			return true;
		if(( first==null && second!=null ) ||( first!=null && second==null ) )
			return false;
		else
		{
			return first.k.equals(second.k) && equals(first.getLeft(),second.getLeft()) && equals(first.getRight(), second.getRight());
		}
	}
	public List<K>  printPaths(Entry<K, V>entry ,List<K> ls)
	{
		if(entry==null)
			return null;
		ls.add(entry.k);
		if(entry.getLeft()==null && entry.getRight()==null)
		{
			printArray(ls);
			return null;
		}
		else
		{
			printPaths(entry.getLeft() , ls);
			printPaths(entry.getRight() , ls);
		}
		return ls;
	}
	
	public void printArray(List<K> ls)
	{
		for(K k:ls)
		{
			System.out.print(k);
		}
		System.out.println("--------------");
	}
	
	public void printArrays()
	{
		for(K k:printPaths(getRoot(), new ArrayList<K>()))
		{
			System.out.print(k);
		}
		System.out.println("--------------");
	}
	
	public int sumOfElement()
	{
		return sumOfElement(getRoot());
	}
	
	protected int sumOfElement(Entry<K, V> entry)
	{
		if(entry==null)
			return 0;
		else return (Integer)entry.getK() +sumOfElement(entry.getLeft()) +sumOfElement(entry.getRight());
	}
	public boolean isMirrorImageTree()
	{
		return isMirrorImageTree(getRoot().getLeft() ,getRoot().getRight());
	}
			
	public boolean isMirrorImageTree(Entry<K, V> left,Entry<K, V> right)
	{
		if(left==null && right==null)
			return true;
		if(left==null || right==null)
			return false;
		if(!left.k.equals(right.k))
			return false;
		return isMirrorImageTree(left.getLeft(), right.getRight()) && isMirrorImageTree(left.getRight(), right.getLeft());
	}
	
	public Entry<K, V> convertToMirrorTree(Entry<K, V> entry)
	{
		if(entry!=null)
		{
			convertToMirrorTree(entry.getLeft());
			convertToMirrorTree(entry.getRight());
			Entry<K, V> temp=entry.getLeft();
			entry.setLeft(entry.getRight());
			entry.setRight(temp);
		}
		return entry;
	}
	public void convertToMirrorTree()
	{
		root=convertToMirrorTree(root);
		System.out.println(root);
	}
	public  boolean printAllAncestor(K k)
	{
		return printAllAncestor(getRoot(), k);
	}
	private boolean printAllAncestor(Entry<K, V> root ,K k)
	{
		if(root==null)
			return false;
		if(root.getLeft().k.equals(k) || root.getRight().k.equals(k) || 
				printAllAncestor(root.getLeft() , k) ||  printAllAncestor(root.getRight() , k))
		{
			System.out.println(root.k);
			return true;
		}
		return false;
	}
	public K findLCA(K k1 , K k2)
	{
		return findLCAForBST(getRoot(), k1 , k2);
	}

	protected K findLCAForBST(Entry<K, V> entry,K k1 , K k2)
	{
		if(entry==null) return null;
		else if(((Comparable)entry.getK()).compareTo(((Comparable)k1))>0 && ((Comparable)entry.getK()).compareTo(((Comparable)k2))>0)
		{
			return findLCAForBST(entry.getLeft(),k1 , k2);
		}else if(((Comparable)entry.getK()).compareTo(((Comparable)k1))<0 && ((Comparable)entry.getK()).compareTo(((Comparable)k2))<0)
		{
			return findLCAForBST(entry.getRight(),k1 , k2);
		}else
			return entry.k;
	}
	public void constructsibling()
	{
		constructsibling(getRoot());
	}
	private void constructsibling(Entry<K, V> root) 
	{
		if(root==null)
			return ;
		if(root.getLeft()!=null)
			root.getLeft().setNextSibling(root.getRight());
		if(root.getRight()!=null)
		{
			if(root.getNextSibling()==null)
				root.getRight().setNextSibling(null);
			else
				root.getRight().setNextSibling(root.getNextSibling().getLeft());
		}	
	}
	public boolean isometricTree(TreeMap<K, V> map)
	{
		return  isometricTree(getRoot(),map.getRoot());
	}
	
	private boolean isometricTree(Entry<K, V> entry1 , Entry<K, V> entry2)
	{
		if(entry1==null && entry2==null)
			return true;
		if( (entry1==null && entry2!=null) || (entry2==null && entry1!=null))
			return false;
		 return isometricTree(entry1.getLeft(), entry2.getLeft()) && isMirrorImageTree(entry1.getRight(), entry2.getRight());
	}
}
