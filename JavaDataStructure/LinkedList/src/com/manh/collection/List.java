package com.manh.collection;

import java.util.Iterator;

public interface List<E> 
{
	public E add(E e);
	
	public E removeNode(E e);
	
	public Iterator<E> iterator();
	
	public void removeFirst();
	
	public E add(E e,int i);
 }
