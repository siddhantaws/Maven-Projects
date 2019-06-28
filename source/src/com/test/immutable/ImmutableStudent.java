package com.test.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ImmutableStudent {
	
	public static void main(String[] args) {
		String a="abcdeeeeddcbfgf";
		ArrayList<String> list =new ArrayList<>();
		for(int i=0;i<a.length();i++) {
			
			list.add(new String(new char[] {a.charAt(i)}));
		}
			
		for(String s :getShrunkArray(list, 3)) {
			System.out.println(s);
			
		}	
	}
	
	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        Map<String,Integer> map =new HashMap();
        for(String s :inputArray){
            if(map.containsKey(s))
               map.put(s, map.get(s)+1);
           else
               map.put(s, 1);
        }
        for(int i=0;i<inputArray.size();i++){
            if(map.get(inputArray.get(i))>=burstLength){
                inputArray.remove(i--);
            }
        }   
       return inputArray;
   }
}