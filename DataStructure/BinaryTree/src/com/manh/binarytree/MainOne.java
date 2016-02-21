package com.manh.binarytree;

public class MainOne 
{
	public static void main(String[] args) 
	{
		BinaryTree<String> binaryTree=new BinaryTree<>();
		binaryTree.add("A");
		binaryTree.add("B");
		binaryTree.add("B");
		binaryTree.add("C");
		binaryTree.add("C");
		binaryTree.add("D");
		binaryTree.add("D");
		System.out.println(binaryTree.structuralSame(binaryTree.first));
	}
}
