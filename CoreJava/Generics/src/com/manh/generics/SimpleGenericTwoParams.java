package com.manh.generics;

public class SimpleGenericTwoParams<K, V> 
{
	private K key;
	private V value;
	
	public SimpleGenericTwoParams(K key, V value) 
	{
		super();
		this.key = key;
		this.value = value;
	}
	public void printTypes(){
        System.out.println("U Type: "+this.key.getClass().getName());
        System.out.println("V Type: "+this.value.getClass().getName());
    }

}
