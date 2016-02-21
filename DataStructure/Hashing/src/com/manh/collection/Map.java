package com.manh.collection;

public interface Map<K, V> 
{
	public void put(K k,V v);
	public Map.Entry<K, V> entrySet();
	
	interface Entry<K,V>
	{
		K getKey();
		V getValue();
		 V setValue(V value);
	}
}
