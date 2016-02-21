package com.manh.collection;

import java.io.Serializable;
import java.util.Comparator;

public class TreeMap<K, V> implements Map<K, V>, Cloneable, Serializable 
{
	
	private Comparator<? super K> comparator;
	
	private Entry<K, V> root=null;
	private int size ;
	public TreeMap(){}
	public TreeMap(Comparator<? super K> comparator)
	{
		this.comparator=comparator;
	}
	
	@Override
	public void put(K k, V v) 
	{
		Entry e=root;
		Entry parent=null;
		int compValue=0;
		if(e==null)
		{
			size++;
			root=new Entry<K,V>(k,v,null);
		}else
		{
			if(comparator!=null)
			{
				
			}else{
					Comparable<? super K> comp=(Comparable<? super K>)k;
				do{
					compValue=comp.compareTo((K) e.k);
					parent=e;
					if(compValue<0)
						e=e.left;
					else if(compValue>0)
						e=e.right;
				}while(e!=null);
				
			}
			Entry<K, V> entry=new Entry<>(k, v, parent);
			if(compValue<0)
				parent.left=entry;
			else if(compValue>0)
				parent.right=entry;
			size++;
		}
	}

	@Override
	public com.manh.collection.Map.Entry<K, V> entrySet() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	static class Entry<K,V> implements Map.Entry<K, V>
	{
		K k;
		V v;
		Entry<K,V> parent;
		Entry<K,V> left;
		Entry<K,V> right;
		Entry(K k, V v,Entry<K,V> parent)
		{
			this.k=k;
			this.v=v;
			this.parent=parent;
		}
		@Override
		public K getKey() 
		{
			return this.k;
		}

		@Override
		public V getValue() 
		{
			return this.v;
		}

		@Override
		public V setValue(V value) 
		{
			return null;
		}
		
	}
}
