package com.manh.collection;

import com.manh.collection.ThreadedBinaryTreeMap.ThreadedEntry;

public class BinaryThreadedTree<K> 
{
	private ThreadedBinaryTreeMap map;

	private ThreadedEntry entry = null;

	public BinaryThreadedTree() {
		this.map = new ThreadedBinaryTreeMap<>();
	}

	public int size() {
		return map.size();
	}

	public void add(K k) {
		map.put(k, new Object());
		entry = map.getRoot();
	}
	
}
