package com.manh.wmos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.sapient.concurrent.locks.ReentrantLock;

public class MainProducerConsumer 
{
	public static void main(String[] args) 
	{
		Lock l=new ReentrantLock();
		Condition notempty=l.newCondition();
		Condition notFull=l.newCondition();
		List<String> strings= new ArrayList<String>();
		Producer producer=new Producer(strings, l, notempty, notFull);
		Consumer consumer=new Consumer(strings, l, notempty, notFull);
		Thread t1=new Thread(producer, "Producer");
		Thread t2=new Thread(consumer, "Consumer");
		t1.start();
		t2.start();
		while(true)
		{
			System.out.println(strings.size());
		}
	}
}
