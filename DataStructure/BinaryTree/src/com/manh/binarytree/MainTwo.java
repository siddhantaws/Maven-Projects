package com.manh.binarytree;

public class MainTwo 
{
	public static void main(String[] args) 
	{
		BinaryTree<Integer> binaryTree=new BinaryTree<>();
		binaryTree.add(1);
		binaryTree.add(3);
		binaryTree.add(2);
		binaryTree.add(4);
		binaryTree.add(5);
		binaryTree.add(6);
		binaryTree.add(7);
		System.out.println(binaryTree.sumOfAllNodes(binaryTree.first));
	}
}
