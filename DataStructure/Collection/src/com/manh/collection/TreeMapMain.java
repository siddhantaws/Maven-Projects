package com.manh.collection;

public class TreeMapMain 
{
	public static void main(String[] args) 
	{
		Map<Integer, String> map=new TreeMap<>();
		map.put(3, "A");
		map.put(2, "C");
		map.put(1, "B");
		System.out.println(map);
		
	}
}
