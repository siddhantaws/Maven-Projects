package com.manh.collection.quardatic;

public class TreeMapMain 
{
	public static void main(String[] args) 
	{
		Map<Integer, String> map=new TreeMap<Integer, String>();
		map.put(3, "A");
		map.put(2, "B");
		map.put(1, "C");
		String s=map.get(1);
	}
}
