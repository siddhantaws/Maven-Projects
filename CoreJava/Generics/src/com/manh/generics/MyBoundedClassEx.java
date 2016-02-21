package com.manh.generics;

import java.util.ArrayList;
import java.util.List;

public class MyBoundedClassEx 
{
	public static void main(String[] args) 
	{
		BoundEx<A> bec = new BoundEx<A>(new B());
        bec.doRunTest();
        BoundEx<B> beb = new BoundEx<B>(new B());
        beb.doRunTest();        
        BoundEx<A> bea = new BoundEx<A>(new A());
        bea.doRunTest();
        //If you uncomment below code it will throw compiler error
        //becasue we restricted to only of type A and its sub classes.
        //BoundEx<String> bes = new BoundEx<String>(new String());
        //bea.doRunTest();
        List<? super A> l1=new ArrayList<>();
        l1.add(null);
	}
}
