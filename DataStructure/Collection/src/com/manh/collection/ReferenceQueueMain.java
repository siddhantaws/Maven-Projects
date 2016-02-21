package com.manh.collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceQueueMain {
	
	public static void main(String[] args) 
	{
		ReferenceQueue<String> rq= new ReferenceQueue(); 
		String s="hello";
		Reference<String> r= new PhantomReference<String>(s,rq); 
		s=null;
		System.gc();	
		System.out.println(rq.poll());
	}
}
