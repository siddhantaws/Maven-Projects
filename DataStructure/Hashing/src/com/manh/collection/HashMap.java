package com.manh.collection;

import java.io.Serializable;

public class HashMap<K, V> implements Map<K, V>, Serializable, Cloneable 
{

	private int size =0;
	

	static final Entry<?, ?>[] EMPTY_TABLE = {};

	/**
	 * The table, resized as necessary. Length MUST Always be a power of two.
	 */
	transient Entry<K, V>[] table = (Entry<K, V>[]) EMPTY_TABLE;
	
	
	
	@Override
	public void put(K k, V v) 
	{
		if(table.length==0)
		{
			table=new Entry[10];
		}
		createNode(k,v);
	}

	protected void createNode(K k, V v)
	{
		int hash=hash(k);
		int i=0;
		Entry<K,V> entry=null;
		int index=index(hash(k),table.length,0);
		while(table[index]!=null)
		{
			index=index(hash(k),table.length,++i);
		}
		table[i]=new Entry<>(k, v, hash, entry);
	}
	
	protected int hash(K k)
	{
		return 10;
	}
	
	protected int index(int hashCode,int length,int i)
	{
		
		return ((hashCode)%10+i*i)%10;
	}
	@Override
	public com.manh.collection.Map.Entry<K, V> entrySet() 
	{
		return null;
	}

	static class Entry<K,V> implements Map.Entry<K, V>
	{

		K k;
		V v;
		int h;
		Entry<K, V> next;
		Entry(K k,V v , int h , Entry<K, V> next)
		{
			this.k=k;
			this.v=v;
			this.h=h;
			this.next=next;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
