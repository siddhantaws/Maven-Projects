package com.manh.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



public class LinkedHashMain
{
	public static void main(String[] args) 
	{
		Map<String, String> map=new LinkedHashMap<>(3, 2);
		map.put("A", "B");
		map.put("C", "D");
		map.put("E", "F");
		
	}
}
