package com.manh.collection;

public class SkipListEntry {
	public String key;
	public Integer value;
	public int pos;    
	
	public SkipListEntry up, down, left, right;
	public static String negInf = "-oo"; // -inf key value
	public static String posInf = "+oo"; // +inf key value

	public SkipListEntry(String k, Integer v) {
		key = k;
		value = v;

		up = down = left = right = null;
	}

	public Integer getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	public Integer setValue(Integer val) {
		Integer oldValue = value;
		value = val;
		return oldValue;
	}

	public boolean equals(Object o) {
		SkipListEntry ent;

		try {
			ent = (SkipListEntry) o; // Test if o is a SkipListEntry...
		} catch (ClassCastException ex) {
			return false;
		}

		return (ent.getKey() == key) && (ent.getValue() == value);
	}

	public String toString() {
		return "(" + key + "," + value + ")";
	}
}
