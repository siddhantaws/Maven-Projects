package com.manh.collection;


public class ThreadedBinaryTreeMap <K , V> extends TreeMap<K, V>
{

	protected ThreadedEntry<K, V> root;
	
	public ThreadedEntry<K, V> getRoot() 
	{
		return root;
	}
	static class ThreadedEntry<K, V>   extends Entry<K, V>
	{
		public ThreadedEntry(K k, Entry<K, V> left, Entry<K, V> right, V v) 
		{
			super(k, left, right, v);
		}
		int lbit;
		int rbit;
		public int getLbit() {
			return lbit;
		}
		public void setLbit(int lbit) {
			this.lbit = lbit;
		}
		public int getRbit() {
			return rbit;
		}
		public void setRbit(int rbit) {
			this.rbit = rbit;
		}
	}
	
	public void put(K k,V v )
	{
		++size;
		Entry<K, V> entry=new ThreadedEntry<K, V>(k, null, null, v);
		addNode(entry);
	}
	@Override
	protected void addNode(Entry<K, V> entry) 
	{
		ThreadedEntry<K, V> entry2=(ThreadedEntry<K, V>)entry;
		ThreadedEntry<K, V> current=null;
		if(root==null)
		{
			root=entry2;
			root.lbit=0;
			root.rbit=1;
			root.left=root.right=root;
		}else if(root.right==root && root.left==root)
		{
			entry2.lbit=root.lbit;
			entry2.left=root.left;
			root.left=entry2;
			root.lbit=1;
			entry2.lbit=0;
			entry2.right=root;
		}else
		{
			boolean directionRight=false;
			boolean directionLeft=false;
			while(true)
			{
				current=root;
				if(((Comparable<K>)current.getK()).compareTo(entry.getK())>0)
				{
					if(current.lbit==0)
					{
						directionLeft=true;
						directionRight=false;
						break ;
					}
					current=(ThreadedEntry)current.left;
				}else
				{
					if (current.rbit == 0) {

						directionLeft = false;
						directionRight = true;
						break;
					} else {
						current =(ThreadedEntry) current.right;
					}
				}
				
				if (directionLeft) {

					entry2.lbit = current.lbit;
					entry2.left = current.left;
					current.left = entry2;
					current.lbit = 1;
					entry2.rbit = 0;
					entry2.right = current;

				} else if (directionRight) {

					entry2.rbit = current.rbit;
					entry2.right = current.right;
					current.right = entry2;
					current.rbit = 1;
					entry2.lbit = 0;
					entry2.left = current;

				}
			}
		}
	}
}
