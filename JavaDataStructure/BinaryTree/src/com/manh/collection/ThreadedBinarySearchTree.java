package com.manh.collection;

public class ThreadedBinarySearchTree 
{
	class TBSTNode
	{
	    int ele;
	    TBSTNode left, right;
	    boolean leftThread, rightThread;
	 
	    /** Constructor **/
	    public TBSTNode(int ele)
	    {
	        this(ele, null, null, true, true);
	    }
	 
	    /** Constructor **/
	    public TBSTNode(boolean leftThread, boolean rightThread)
	    {
	        this.ele = Integer.MAX_VALUE;
	        this.left = this;
	        this.right = this;
	        this.leftThread = leftThread;
	        this.rightThread = rightThread;
	    }
	 
	    /** Constructor **/
	    public TBSTNode(int ele, TBSTNode left, TBSTNode right, boolean leftThread, boolean rightThread)
	    {
	        this.ele = ele;
	        this.left = left;
	        this.right = right;
	        this.leftThread = leftThread;
	        this.rightThread = rightThread;
	    }
	}
	 

	    private TBSTNode root;
	 
	    /** Constructor **/
	    public ThreadedBinarySearchTree () 
	    {
	        root = new TBSTNode(true, false);      
	    }
	 
	    /** Function to clear tree **/
	    public void clear()
	    {
	        root = new TBSTNode(true, false);  
	    }
	 
	    /** Function to insert an element **/
	    public void insert(int ele) 
	    {
	        TBSTNode ptr = findNode(root, ele);
	 
	        /** element already present **/
	        if (ptr == null)
	            return;         
	 
	        if (ptr.ele < ele) 
	        { 
	            TBSTNode nptr = new TBSTNode(ele, ptr, ptr.right, true, true);            
	            ptr.right = nptr;
	            ptr.rightThread = false;
	        }
	        else
	        {
	            TBSTNode nptr = new TBSTNode(ele, ptr.left, ptr, true, true);         
	            ptr.left = nptr;
	            ptr.leftThread = false;
	        }
	    }
	 
	    /** function to find node **/
	    public TBSTNode findNode(TBSTNode r, int ele)
	    {
	        if (r.ele < ele)
	        {
	            if (r.rightThread)
	                return r;
	            return findNode(r.right, ele);
	        }
	        else if (r.ele > ele)
	        {
	            if (r.leftThread)
	                return r;
	            return findNode(r.left, ele);
	        }
	        else
	            return null;        
	    }
	 
	    /** Function to search for an element **/
	    public boolean search(int ele) 
	    {
	        return findNode(root, ele) == null;
	    }
	 
	    /** Function to print tree **/
	    public void inOrder() 
	    {
	        TBSTNode temp = root;
	        for (;;)
	        {
	            temp = insucc(temp);
	            if (temp == root)
	                break;
	            System.out.print(temp.ele +" ");
	        }
	    } 
	 
	    /** Function to get inorder successor **/
	    public TBSTNode insucc(TBSTNode tree)
	    {
	        TBSTNode temp;
	        temp = tree.right;
	        if (!tree.rightThread)
	            while (!temp.leftThread)
	                temp = temp.left;
	        return temp;
	    }
	 

	    public static void main(String[] args)
	    {                 
	    	ThreadedBinarySearchTree  binarySearchTree=new ThreadedBinarySearchTree();
	    	binarySearchTree.insert(10);
	    	binarySearchTree.insert(5);
	    	binarySearchTree.insert(20);
	    	binarySearchTree.inOrder();
	    }
}
