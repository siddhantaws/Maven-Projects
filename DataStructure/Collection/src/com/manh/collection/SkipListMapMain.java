package com.manh.collection;

public class SkipListMapMain 
{
	public static void main(String[] args) 
	{
		SkipList<String, String> list=new SkipList<>();
		list.insert("A", "A");
		list.insert("B", "B");
		list.insert("C", "C");
	}
}
