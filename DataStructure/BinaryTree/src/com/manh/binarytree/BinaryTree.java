package com.manh.binarytree;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree<K> 
{
	public  Node<K> first;

	private int size;
	Node<K> node;

	class BinaryTreeIterator<E> implements Iterator<E>
	{
		private Node<K> currNode=first;
		
		@Override
		public boolean hasNext() 
		{
			return currNode==null;
		}

		@Override
		public E next() 
		{
			return null;
		}

		@Override
		public void remove() 
		{
			
		}
		
	}
	
	public void add(K k)
	{
		size++;
		if(size==1)
		{
			first=new Node(k);
			return ;
		}
		Node<K> parent=getParent((size%2==0 ? size : size-1));
		if(parent.left==null)
			parent.left=new Node(k);
		else
			parent.right=new Node(k);
	}
	
	private Node<K> getParentRecus(int size)
	{
		size=(size>3 && size%2==0 )? size : size-1;
		if(size>3 && (size%3!=0 && size%2==0))
		{
			getParentRecus(size/2);
			node=node.left;
		}else if(size>3 &&  (size%3==0 || size%2==0))
		{
			getParentRecus(size/2);
			node=node.right;
		}
		return node;
	}
	
	
	private Node<K> getParent(int size)
	{
		if(size<=3)
			return first;
		node=first; 
		return getParentRecus(size);
	}
	
	public void preOrderTraversal(Node<K> head)
	{
		if(head!=null)
		{
			System.out.println(head);
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
		}
	}
	
	public int heightOfBinaryTree(Node<K> head)
	{
		int leftHeight=0;
		int rightHeight=0;
		if(head==null) return 0;
		leftHeight=heightOfBinaryTree(head.left);
		rightHeight=heightOfBinaryTree(head.right);
		if(leftHeight>rightHeight)
			return  leftHeight+1;
		else
			return  rightHeight+1;
	}
	
	public Node<K> minorTree(Node<K> node)
	{
		Node<K> temp=null;
		if(node!=null)
		{
			minorTree(node.left);
			minorTree(node.right);
			temp=node.left;
			node.left=node.right;
			node.right=temp;
		}
		return node;
	}
	
	public Node<K> getDeepestNode(Node<K> head)
	{
		Queue<Node<K>> q=new LinkedBlockingQueue<>();
		q.add(head);
		Node<K> node=null;
		while(!q.isEmpty())
		{
			node=q.poll();
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
		return node;
	}
	
	public void inOrderTraversal(Node<K> head)
	{
		if(head!=null)
		{
			preOrderTraversal(head.left);
			System.out.println(head);
			preOrderTraversal(head.right);
		}
	}
	
	public void postOrderTraversal(Node<K> head)
	{
		if(head!=null)
		{
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
			System.out.println(head);
		}
	}
	
	public void levelOrderTraversal(Node<K> head)
	{
		Queue<Node<K>> q=new LinkedBlockingQueue<>();
		Stack<Node<K>> stack=new Stack<>();
		q.add(head);
		while(!q.isEmpty())
		{
			Node<K> temp=q.poll();
			if(temp.right!=null)
				q.add(temp.right);
			if(temp.left!=null)
				q.add(temp.left);
			stack.push(temp);
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop().k);
		}
	}
	
	public int sumOfAllNodes(Node<K> node)
	{
		if(node==null) return 0;
		return  ((int)node.k+sumOfAllNodes(node.left)+sumOfAllNodes(node.right));
	}
	public boolean structuralSame(Node<K> node1,Node<K> node2)
	{
		if(node1==null && node2==null)
			return true;
		return (node1.k.equals(node2.k) && 
				structuralSame(node1.left,node1.right) && structuralSame(node1.right,node1.left)) ;
	}
	
	public boolean structuralSame(Node<K> head)
	{
		return structuralSame(head.left, head.right);
	}
	public void deleteAllNodes(Node<K> head)
	{
		if(head==null) return ;
		
		deleteAllNodes(head.left);
		deleteAllNodes(head.right);
		head.left=null;
		head.right=null;
		head=null;
	}
	public int binaryTreeSize(Node<K> head)
	{
		if(head==null) return 0;
		return binaryTreeSize(head.left)+binaryTreeSize(head.right)+1;
	}
	public Node<K> max(Node<K> head)
	{
		Node<K> max=null;
		Node<K> left;
		Node<K> right;
		if(head!=null)
		{
			max=head;
			left=max(head.left);
			right=max(head.right);
			if(left!=null && right!=null && ((Comparable)left.k).compareTo(((Comparable)right.k))>0)
				max=head.left;
			else if(left!=null && right!=null && ((Comparable)left.k).compareTo(((Comparable)right.k))<0)
				max=head.right;
			if(((Comparable)head.k).compareTo(((Comparable)max.k))>0)
				max=head;
		}
		return max;
	}
	
	static class Node<K>
	{
		private K k;
		private Node<K> left;
		private Node<K> right;
		
		Node(K k)
		{
			this.k=k;
		}
		
		Node<K> rightNode()
		{
			return right;
		}
		
		Node<K> leftNode()
		{
			return left;
		}
		
		@Override
		public String toString() 
		{
			return k.toString();
		}
		
	}
}
