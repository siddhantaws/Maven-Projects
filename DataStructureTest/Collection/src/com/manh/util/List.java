package com.manh.util;

import java.io.Serializable;
import java.util.Collection;

public interface List<E> extends Collection<E> ,Cloneable ,Serializable
{
	@Override
	public boolean add(E e);
	
	public void set(E e,int index);
	
	public void addFirst(E e);
	
	@Override
	public boolean remove(Object o);
	
}
