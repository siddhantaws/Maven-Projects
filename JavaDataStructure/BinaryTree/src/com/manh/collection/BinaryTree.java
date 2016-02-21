package com.manh.collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.manh.collection.TreeMap.Entry;

public class BinaryTree<K> {
	private TreeMap map;

	private Entry entry = null;

	public BinaryTree() {
		this.map = new TreeMap<>();
	}

	public int size() {
		return map.size();
	}

	public void add(K k) {
		map.put(k, new Object());
		entry = map.getRoot();
	}

	public void preOrderTraversalRecur() 
	{
		
		preOrderTraversalRecur(entry.getLeft());
	}

	public void inOrderTraversalRecur() 
	{
		inOrderTraversalRecur(entry);
	}

	protected void inOrderTraversalRecur(Entry entry) {
		if (entry != null) {
			inOrderTraversalRecur(entry.left);
			System.out.println(entry.k);
			inOrderTraversalRecur(entry.right);
		}
	}

	protected void preOrderTraversalRecur(Entry entry) {
		if (entry != null) {
			System.out.println(entry.k);
			preOrderTraversalRecur(entry.left);
			preOrderTraversalRecur(entry.right);
		}
	}

	public void preOrderTraversalIteral() {
		Stack<Entry> s = new Stack<>();
		while (true) {
			while (entry != null) {
				System.out.println(entry.k);
				s.push(entry);
				entry = entry.getLeft();
			}
			if (s.isEmpty())
				break;
			Entry entryNew = s.pop();
			entry = entryNew.getRight();
		}
	}

	public void inOrderTraversalIteral() {
		Stack<Entry> nodes = new Stack<>();
		while (true) {
			while (entry != null) {
				nodes.push(entry);
				entry = entry.left;
			}
			if (nodes.isEmpty())
				break;
			entry = nodes.pop();
			System.out.println(entry.k);
			entry = entry.right;
		}
	}

	public void postOrderTraversal() {
		postOrderTraversal(entry);
	}

	protected void postOrderTraversal(Entry entry) {
		if (entry != null) {
			postOrderTraversal(entry.left);
			postOrderTraversal(entry.right);
			System.out.println(entry.k);
		}
	}

	public void levelOrderTraversal() {
		Queue<Entry> queue = new ArrayDeque<>();
		queue.add(entry);
		while (true) {
			Entry en = queue.peek();
			System.out.println(queue.poll().k);
			if (en.getLeft() != null)
				queue.add(en.getLeft());
			if (en.getRight() != null)
				queue.add(en.getRight());
		}
	}

	public K findMax() {
		return findMax(entry);
	}

	protected K findMax(Entry entry) {
		K maxvalue = null;
		K left, right;
		if (entry != null) {
			K root = (K) entry.k;
			left = findMax(entry.getLeft());
			right = findMax(entry.getLeft());
			if (left == null && right == null)
				return maxvalue;
			else if (left != null && right == null)
				maxvalue = left;
			else
				maxvalue = right;
			if (((Comparable) left).compareTo((Comparable) right) > 0)
				maxvalue = left;
			else if (((Comparable) left).compareTo((Comparable) right) < 0)
				maxvalue = right;

			if (((Comparable) root).compareTo(maxvalue) > 0)
				maxvalue = root;
		}
		return maxvalue;
	}

	public boolean searchElement(K k) {
		return searchElement(entry, k);
	}

	protected boolean searchElement(Entry entry, K k) {
		if (entry == null)
			return false;
		else {
			if (entry.k.equals(k)) {
				return true;
			} else {

				boolean search = searchElement(entry.getLeft(), k);
				if (search)
					return search;
				else
					return searchElement(entry.getRight(), k);
			}

		}
	}

	public void delete() {
		map.deleteBinaryTree();
	}

	public int heightOfTree() {
		return map.heightOfTree(map.getRoot());
	}

	public K findDeepestNode() {
		return (K) map.findDeepestNode();
	}

	public int findFullNodes() {
		return map.findFullNodes(map.getRoot());
	}

	public int findHalfNodes() {
		return map.findHalfNodes(map.getRoot());
	}

	@Override
	public boolean equals(Object obj) {
		BinaryTree<K> binaryTree = (BinaryTree<K>) obj;
		return map.equals(binaryTree.map);
	}
	public void printArrays()
	{
		map.printArrays();
	}
	public int sumOfElement()
	{
		return map.sumOfElement();
	}
	public boolean isMirrorImageTree()
	{
		return map.isMirrorImageTree();
	}
	public void convertToMirrorTree()
	{
		map.convertToMirrorTree();
	}
	public  boolean printAllAncestor(K k)
	{
		return map.printAllAncestor( k );
	}
	public K findLCA(K k1 , K k2)
	{
		return (K)map.findLCA(k1, k2);
	}
	public void constructsibling()
	{
		map.constructsibling();
	}
}
