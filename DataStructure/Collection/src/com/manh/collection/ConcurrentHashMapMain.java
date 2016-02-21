package com.manh.collection;

import java.util.Iterator;

import com.manh.collection.ConcurrentHashMap.EntrySet;
import com.manh.collection.Map.Entry;

public class ConcurrentHashMapMain 
{
	public static void main(String[] args) {
		Map<String, String> map=new ConcurrentHashMap<>(5 ,0.5f ,16);
		map.put("A", "A");
		map.put("B", "A");
		map.put("C", "A");
		
		map.get("A");
		Set<Map.Entry<String, String>> sets=map.entrySet();
		Iterator<Map.Entry<String, String>> iterator=sets.iterator();
		while(iterator.hasNext())
		{
			Entry<String, String> entry=iterator.next();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}
}
