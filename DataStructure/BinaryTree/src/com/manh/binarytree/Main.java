package com.manh.binarytree;

public class Main 
{
	public static void main(String[] args) 
	{
		BinaryTree<String> binaryTree=new BinaryTree<>();
		binaryTree.add("A");
		binaryTree.add("B");
		binaryTree.add("C");
		binaryTree.add("D");
		binaryTree.add("E");
		binaryTree.add("F");
		binaryTree.add("G");
		binaryTree.add("H");
		binaryTree.add("I");
		
		//binaryTree.preOrderTraversal(binaryTree.first);
		//System.out.println(binaryTree.max(binaryTree.first));
		//System.out.println(binaryTree.binaryTreeSize(binaryTree.first));
		//binaryTree.deleteAllNodes(binaryTree.first);
		//System.out.println(binaryTree.binaryTreeSize(binaryTree.first));
		//binaryTree.levelOrderTraversal(binaryTree.first);
		//System.out.println(binaryTree.heightOfBinaryTree(binaryTree.first));
		//System.out.println(binaryTree.getDeepestNode(binaryTree.first));
		System.out.println(binaryTree.minorTree(binaryTree.first));
		System.out.println(binaryTree.first);
	}
}
