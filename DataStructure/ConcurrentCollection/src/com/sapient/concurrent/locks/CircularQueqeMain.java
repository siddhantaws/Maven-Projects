package com.sapient.concurrent.locks;

public class CircularQueqeMain 
{
	public static void main(String[] args) 
	{
		CircularQueue<String> circularQueue=new CircularQueue<>();
		circularQueue.add("A");
		circularQueue.add("B");
		circularQueue.add("C");
		circularQueue.add("D");
		circularQueue.add("E");
		circularQueue.add("F");
		circularQueue.add("G");
		circularQueue.add("H");
		circularQueue.add("I");
		circularQueue.reverse(4);
	//	circularQueue.poll();
		
	}
}
