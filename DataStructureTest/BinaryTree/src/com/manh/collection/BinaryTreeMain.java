package com.manh.collection;

public class BinaryTreeMain 
{	
	public static void main(String[] args) 
	{
		BinaryTree<Integer> binaryTree=new BinaryTree<>();
		binaryTree.add(10);
		binaryTree.add(20);
		binaryTree.add(30);
		binaryTree.add(40);
		binaryTree.add(50);
		binaryTree.add(60);
		binaryTree.add(70);
		//binaryTree.add(80);
		//binaryTree.add("E");
		//binaryTree.add("I");
		//binaryTree.heightOfTree();
		//System.out.println(binaryTree.numberOfLeaps());
		//System.out.println(binaryTree.sumOfAllNodes());
		//binaryTree.printAncestor(80);
		binaryTree.zigzagBinaryTree();
	}
}
