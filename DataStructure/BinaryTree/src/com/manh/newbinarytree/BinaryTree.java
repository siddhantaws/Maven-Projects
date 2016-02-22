package com.manh.newbinarytree;

import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> 
{

	private Node root;
	
	public Node getRoot() 
	{
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	private E max=null;
	public BinaryTree()
	{
		root=null;
	}
	
	public boolean isEmpty()
    {
        return root == null;
    }
	
	
	 public void add(E e)
     {
         root = isEmpty() ? new Node(e) :  insert(e);
     }
	 
	 public void levelOrderTraversal()
	 {
		 levelOrderTraversal(root);
	 }
	 
	 protected void levelOrderTraversal(Node node)
	 {
		 Queue<Node<E>> q=new ArrayDequeCust<>();
		 q.add(node);
		 Stack<E> stack=new Stack<>();
		 while(!q.isEmpty())
		 {
			 Node<E> n=q.poll();
			 stack.add(n.getData());
			 if(n.getRight()!=null)
				 q.add(n.getRight());
			 if(n.getLeft()!=null)
				 q.add(n.getLeft());
		 }
		 while(!stack.isEmpty())
		 {
			 System.out.println(stack.pop());
		 }
 	 }
	 
	 
	 private Node insert(E e)
     {
		 Node parent;
		 Node t=root;
		 int cmp;
		 Comparable<? super E> k = (Comparable<? super E>) e;
         do {
             parent = t;
             cmp = k.compareTo((E)t.e);
             if (cmp < 0)
                 t = t.left;
             else if (cmp > 0)
                 t = t.right;
         } while (t != null);
         if(cmp < 0 )
        	 parent.setLeft(new Node(e)) ;
         else
        	 parent.setRight(new Node(e)) ;
         return root;
     }  
	 
	 public void printAncestor(E e)
	 {
		 printAncestor( root , e );
	 }
	 
	 public long sumOfBinaryTree()
	 {
		 return sumOfBinaryTree(root);
	 }
	 
	 protected long sumOfBinaryTree(Node node )
	 {
		 if(node==null)
			 return 0;
		 else 
			return (	 new Long(node.getData().hashCode())  + 
							sumOfBinaryTree(node.getLeft()) + 
								sumOfBinaryTree(node.getRight()) );
	 }
	 	 
	 protected boolean printAncestor(Node node,E e)
	 {
		if(node==null )
			return false;
		if( (node.getLeft()!=null && node.getLeft().getData().equals(e))  || 
				(node.getRight()!=null && node.getRight().getData().equals(e) ) 
				|| printAncestor(node.getLeft(), e) || 
				printAncestor(node.getRight(), e))
			System.out.println(node.getData());
		return true;
	 }
	 
	 public int count()
	 {
		 return count(root);
	 }
	 
	 protected int count(Node node)
	 {
		 if(node==null)
			 return 0;
		 else
		 return count(node.getLeft()) 
				 +1
				 +count(node.getRight()) ;
	 }
	
	public E getMax()
	{
		return getMaxIterative(root);
	}
	
	public boolean search(E e)
	{
		return searchIterative(root ,e );
	}

	public void deleteBinaryTree()
	{
		delete(root);
	}
	
	public int height()
	{
		return heightIterative(root);
	}
	
	public void preOrderTraversal()
	{
		preOrderTraversal(root);
	}
	
	private  void preOrderTraversal(Node head)
	{
		if(head!=null)
		{
			System.out.println(head.e);
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
		}
	}
	
	public void inOrderTraversal()
	{
		inOrderTraversal(root);
	}
	
	public void postOrderTraversal()
	{
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(Node head)
	{
		if(head!=null)
		{
			postOrderTraversal(head.left);
			postOrderTraversal(head.right);
			System.out.println(head.e);
		}
	}
	
	private void inOrderTraversal(Node head)
	{
		if(head!=null)
		{
			inOrderTraversal(head.left);
			System.out.println(head.e);
			inOrderTraversal(head.right);
		}
	}
	
	protected int heightIterative(Node<E> node)
	{
		Queue<Node<E>> q=new ArrayDequeCust<>();
		q.add(node);
		q.add(null);
		int level=0;
		while(!q.isEmpty())
		{
			Node<E> n=q.poll();
			if(n==null)
			{
				if(!q.isEmpty())
					q.add(null);
				else
					level++;
					
			}
			if(n!=null && n.getLeft()!=null)
				q.add(n.getLeft());
			if(n!=null && n.getRight()!=null)
				q.add(n.getRight());
		}
		return  level;
	}
	
	public int getFullNode()
	{
		return getFullNode(root);
	}
	
	protected int getFullNode(Node<E> node)
	{
		Queue<Node<E>> q=new ArrayDequeCust<>();
		q.add(node);
		int level=0;
		while(!q.isEmpty())
		{
			Node<E> n=q.poll();
			if(n!=null && n.getLeft()!=null && n.getRight()!=null)
			{
				level++;
				q.add(n.getLeft());
				q.add(n.getRight());
			}else if(n!=null && n.getLeft()!=null)
			{
				q.add(n.getLeft());
			}else if(n!=null && n.getRight()!=null)
			{
				q.add(n.getRight());
			}
		}
		return level;
	}
	
	
	public int getHalfNode()
	{
		return getHalfNode(root);
	}
	
	protected int getHalfNode(Node<E> node)
	{
		Queue<Node<E>> q=new ArrayDequeCust<>();
		q.add(node);
		int level=0;
		while(!q.isEmpty())
		{
			Node<E> n=q.poll();
			if(n!=null && n.getLeft()!=null && n.getRight()!=null)
			{
				q.add(n.getLeft());
				q.add(n.getRight());
			}else if(n!=null && n.getLeft()!=null && n.getRight()==null)
			{
				level++;
				q.add(n.getLeft());
			}else if(n!=null && n.getRight()!=null && n.getLeft()==null) 
			{
				level++;
				q.add(n.getRight());
			}
		}
		return level;
	}
	
	protected int height(Node<E> node)
	{
		int lheight,rheight;
		if(node==null)
			return 0;
		lheight=height(node.getLeft());
		rheight=height(node.getRight());
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	protected void delete(Node<E> node) 
	{
		if(node==null)
			return ;
		delete(node.getLeft());
		delete(node.getRight());
		node=null;
	}
	
	protected boolean searchIterative(Node<E> node, E e)
	{
		Queue<Node<E>> q=new ArrayDequeCust<>();
		q.add(node);
		while(!q.isEmpty())
		{
			Node<E> n=q.poll();
			if(e.equals(n.getData()))
				return true;
			if(n.getLeft()!=null)
				q.add(n.getLeft());
			if(n.getRight()!=null)
				q.add(n.getRight());
		}
		return false;
	}
	protected boolean search(Node<E> node , E e)
	{
		if(node==null)
			return false;
		if(e.equals(node.getData()))
			return true;
		else
		{
			if(search(node.getLeft(), e))
				return true;
			else
				return search(node.getRight(), e);
		}
	}
	
	public E getMaxIterative(Node<E> node)
	{
		Queue<Node> q=new ArrayDequeCust<>();
		q.add(node);
		max = node.getData();
		while(!q.isEmpty())
		{
			Node<E> n=q.poll();
			if(max.compareTo(n.getData())<0)
				max=n.getData();
			if(n.getLeft()!=null)
				q.add(n.getLeft());
			if(n.getRight()!=null)
				q.add(n.getRight());
		}
		return max;
	}
	
	protected E getMax(Node<E> node)
	{
		if(node!=null)
		{
			E e=node.getData();
			E e1=null;
			E e2=null;
			if(node.getLeft()!=null)
				e1=getMax(node.getLeft());
			if(node.getRight()!=null)
				e2=getMax(node.getRight());
			if (e1!=null && e2!=null &&  e1.compareTo(e2) >0)
				max=e1; 
			else if(e1!=null && e2!=null)
				max=e2;
			if(e!=null && max!=null && e.compareTo(max)>0)
				max=e;
		}
		return max;
	}
	
	static class Node<E extends Comparable<E>>  
	 {    
	     Node left, right;
	     E e;
	 
	     /* Constructor */
	     public Node()
	     {
	         left = null;
	         right = null;
	         
	     }
	     /* Constructor */
	     public Node(E e)
	     {
	         left = null;
	         right = null;
	         this.e = e;
	     }
	     /* Function to set left node */
	     public void setLeft(Node n)
	     {
	         left = n;
	     }
	     /* Function to set right node */ 
	     public void setRight(Node n)
	     {
	         right = n;
	     }
	     /* Function to get left node */
	     public Node getLeft()
	     {
	         return left;
	     }
	     /* Function to get right node */
	     public Node getRight()
	     {
	         return right;
	     }
	     /* Function to set data to node */
	     public void setData(E e)
	     {
	         e = e;
	     }
	     /* Function to get data from node */
	     public E getData()
	     {
	         return e;
	     }     
	 }
}