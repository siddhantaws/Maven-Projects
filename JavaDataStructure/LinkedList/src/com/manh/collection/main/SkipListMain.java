package com.manh.collection.main;

import com.manh.collection.SkipList;


public class SkipListMain 
{
	public static void main(String[] args) 
	{
		SkipList S = new SkipList();
	    S.put("ABC", 123);
	    S.put("DEF", 123);
	    S.put("KLM", 123);
	    S.put("HIJ", 123);
	    S.put("GHJ", 123);
	    S.printHorizontal();
	}
}
