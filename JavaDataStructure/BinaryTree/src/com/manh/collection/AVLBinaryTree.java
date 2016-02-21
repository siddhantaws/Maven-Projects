package com.manh.collection;

import com.manh.collection.TreeMap.Entry;

public class AVLBinaryTree<K> 
{
	private TreeMap map;

	private Entry entry = null;

	public AVLBinaryTree() 
	{
		this.map = new AVLBinaryTreeMap<>();
	}
	public void add(K k) 
	{
		map.put(k, new Object());
		entry = map.getRoot();
	}
}
