package com.manh.collection;

public class BinaryTreeMain 
{
	public static void main(String[] args) 
	{
		BinaryTree<Integer> binaryTree=new BinaryTree<>();
		binaryTree.add(10);
		binaryTree.add(5);
		binaryTree.add(12);
		binaryTree.add(4);
		binaryTree.add(6);
		binaryTree.add(11);
		binaryTree.add(13);
		System.out.println(binaryTree.heightOfTree());;
	//	System.out.println(binaryTree.searchElement(11));
		//System.out.println(binaryTree.findMax());
		/*binaryTree.add(3);
		binaryTree.add(6);
		binaryTree.add(11);
		binaryTree.add(14);
		binaryTree.add(2);
		BinaryTree<Integer> binaryTree1=new BinaryTree<>();
		binaryTree1.add(10);
		binaryTree1.add(5);
		binaryTree1.add(12);
		binaryTree1.add(3);
		*//*binaryTree.add(6);
		binaryTree.add(11);
		binaryTree.add(14);*/
		//binaryTree.preOrderTraversalRecur();
		//binaryTree.inOrderTraversalIteral();
		//binaryTree.postOrderTraversal();
		//binaryTree.levelOrderTraversal();
		//System.out.println(binaryTree.findMax());
		//System.out.println(binaryTree.searchElement(11));
		//binaryTree.delete();
		//System.out.println(binaryTree.heightOfTree());
		//System.out.println(binaryTree.size());
		//System.out.println(binaryTree.findDeepestNode());
		//System.out.println(binaryTree.findFullNodes());
		//System.out.println(binaryTree.findHalfNodes());
		//System.out.println(binaryTree.equals(binaryTree1));
		//binaryTree.printArrays();
		//System.out.println(binaryTree.isMirrorImageTree());
		//binaryTree.convertToMirrorTree();
		//binaryTree.printAllAncestor(2);
		//System.out.println(binaryTree.findLCA(2, 6));
		binaryTree.constructsibling();
	}
}
