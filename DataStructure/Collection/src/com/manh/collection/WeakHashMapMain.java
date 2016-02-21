package com.manh.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapMain 
{
	public static void main(String[] args) 
	{

		
        Map weakHashMap = new WeakHashMap();
        
        String keyWeakHashMap = new String("keyWeakHashMap");
        

        weakHashMap.put(keyWeakHashMap, "Atul");
        System.gc();
        System.out.println("Before: weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
        
        keyWeakHashMap = null;
        
        System.gc();  
        
        System.out.println("After: hash  weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
	}
}
