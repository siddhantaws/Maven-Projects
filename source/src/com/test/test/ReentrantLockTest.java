package com.test.test;

import com.test.concurrent.locks.Lock;
import com.test.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	static final Lock lock =new ReentrantLock(true);
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					lock.lock();	
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					lock.unlock();
				}	
			}
		});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();	
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					lock.unlock();
				}	
			}
		});
		t2.start();
		
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.tryLock();	
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					lock.unlock();
				}	
			}
		});
		t3.start();
		/*ReentrantLockTest test =new ReentrantLockTest();
		ReentrantLockTest.MyTest test2 =test.new MyTest();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				test2.add();
		}});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				test2.add();
			}
		});
		t2.start();*/
	}
	
	class MyTest{
	
		public void add() {
			
			synchronized (MyTest.class) {
				System.out.println(1);
				System.out.println(2);
			}
		}
		
	}
}
