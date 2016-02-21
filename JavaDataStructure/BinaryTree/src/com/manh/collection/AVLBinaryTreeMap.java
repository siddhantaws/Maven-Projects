package com.manh.collection;


public class AVLBinaryTreeMap<K, V> extends TreeMap<K, V>
{
	@Override
	public void put(K k, V v) 
	{
		super.put(k, v);
		int balance = balance(root.left, root.right);
		 if(balance > 1)
		 {
			 if(heightOfTree(root.left.left) >= heightOfTree(root.left.right))
			 {
				 root = rightRotate(root);
		 	 }else
		 	 {
		 		root.left = leftRotate(root.left);
                root = rightRotate(root);
		 	 }
		 }else if(balance<-1)
		 {
			 if(heightOfTree(root.right.right) >= heightOfTree(root.right.left))
			 {
				 root = leftRotate(root);
		 	 }else
		 	 {
		 		root.left = rightRotate(root.right);
                root = leftRotate(root);
		 	 }
		 }else
		 {
			 root.height=heightOfTree(root);
		 }
	}
	
	private int balance(Entry<K, V> rootLeft, Entry<K, V> rootRight)
	{
	   return heightOfTree(rootLeft) - heightOfTree(rootRight);
	}
	
	protected Entry<K, V> rightRotate(Entry<K, V> root)
	{
		Entry newRoot = root.left;
		root.left= root.left.right;
		newRoot.right=root;
		root.height = heightOfTree(root);
		newRoot.height = heightOfTree(newRoot);
		return newRoot;
	}
	
	protected Entry<K, V> leftRotate(Entry<K, V> root)
	{
		Entry newRoot = root.right;
		root.right= root.right.left;
		newRoot.left=root;
		root.height = heightOfTree(root);
		newRoot.height = heightOfTree(newRoot);
		return newRoot;
	}
	
}
