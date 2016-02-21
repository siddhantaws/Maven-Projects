package com.manh.collection;

import java.util.WeakHashMap;

public class EnumMapMain 
{
	public static void main(String[] args) 
	{
		Map<Pizza, Integer> map=new EnumMap<>(Pizza.class);
		map.put(Pizza.Medium, 12);
		map.put(Pizza.Large, 15);
		map.put(Pizza.Samll, 10);
		map.put(Pizza.Samll, 20);
		map.get(Pizza.Samll);
	}
}
