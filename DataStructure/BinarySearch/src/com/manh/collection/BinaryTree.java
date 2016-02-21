package com.manh.collection;

import java.util.Collections;

public class BinaryTree 
{
	Node root;

	public static void main(String[] args) 
	{

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");
		
		
		theTree.addNode(85, "Salesman 1");

		theTree.addNode(65, "Project Manager");

		// Different ways to traverse binary trees

		//theTree.inOrderTraverseTree(theTree.root);

		 //theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 75");

	//	System.out.println(theTree.findNode(75));

	}
	
	public void inOrderTraverseTree(Node focusNode) 
	{

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}
	
	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}
	
	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

	public void addNode(int key, String name)
	{
		Node newNode = new Node(key, name);
		 if (root == null) 
		 {
				root = newNode;
		 }else{
			// Set root as the Node we will start
			// with as we traverse the tree
			 Node focusNode = root;
			 Node parent;
			 while (true) 
			 {
					// root is the top parent so we start
					// there
					parent = focusNode;
					// Check if the new node should go on
					// the left side of the parent node
					if (key < focusNode.key) {

						// Switch focus to the left child

						focusNode = focusNode.leftChild;

						// If the left child has no children

						if (focusNode == null) {

							// then place the new node on the left of it

							parent.leftChild = newNode;
							return; // All Done

						}

					} else { // If we get here put the node on the right

						focusNode = focusNode.rightChild;

						// If the right child has no children

						if (focusNode == null) {

							// then place the new node on the right of it

							parent.rightChild = newNode;
							return; // All Done

						}

					}

				}
		 }
		
	}
	
	private class Node
	{
		int key;
		String name;
		Node leftChild;
		Node rightChild;
		Node(int key, String name) 
		{
			this.key = key;
			this.name = name;
		}
		public String toString() 
		{
				        return name + " has the key " + key;
				 
		}		
	}
}
