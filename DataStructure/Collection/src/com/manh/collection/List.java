package com.manh.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;

public interface List<E>
{
	int indexOf(Object o);
	Object[] toArray();
	int lastIndexOf(Object o);
	int size();
	boolean isEmpty();
	boolean contains(Object o);
	Iterator<E> iterator();
	boolean remove(Object o);
	boolean add(E e);
	int hashCode();
	E get(int index);
	E set(int index, E element);
	void add(int index, E element);
	ListIterator<E> listIterator();
	ListIterator<E> listIterator(int index);
	List<E> subList(int fromIndex, int toIndex);
	
}
