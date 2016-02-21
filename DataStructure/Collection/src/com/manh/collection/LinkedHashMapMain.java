package com.manh.collection;


public class LinkedHashMapMain 
{
	public static void main(String[] args) 
	{
		Map<String, String> map=new LinkedHashMap<>(3,0.5f);
		map.put("A", "B");
		map.put("B", "C");
		map.put("D", "E");
		map.put("F", "G");
	}
}
