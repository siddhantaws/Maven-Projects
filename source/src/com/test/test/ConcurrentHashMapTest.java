package com.test.test;

import com.test.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		ConcurrentHashMap<Student, String> map=new ConcurrentHashMap<>(4);
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					map.put(new Student(1, "SS1"), "A");
					map.put(new Student(2, "SS2"), "A");
					map.put(new Student(3, "SS3"), "A");
					map.put(new Student(4, "SS3"), "A");
					map.put(new Student(5 , "SS3"), "A");
					map.put(new Student(6 , "SS3"), "A");
					map.put(new Student(7 , "SS3"), "A");
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t2.start();
	}
	
	static class Student implements Comparable<Student>{
		private int id;
		private String name ;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			return prime;
		}

		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		@Override
		public int compareTo(Student o) {
			return this.id - o.id ;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
		
	}
}
