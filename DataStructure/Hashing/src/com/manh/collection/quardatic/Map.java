package com.manh.collection.quardatic;

public interface Map<K, V> 
{
	public void put(K k,V v);
	
	public void remove(K k);
	public V get(K k);
	interface Entry<K,V> 
	{
		K getKey();
		V getValue();
		V setValue(V value);
	} 
}
