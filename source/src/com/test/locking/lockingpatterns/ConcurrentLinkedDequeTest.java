package com.test.locking.lockingpatterns;

import com.test.concurrent.ConcurrentLinkedDeque;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConcurrentLinkedDequeTest {

    public static void main(String[] args) {
    	final ConcurrentLinkedDeque<String> strings =new ConcurrentLinkedDeque<String>();
    	Thread t1=new Thread(new Runnable() {
		
			@Override
			public void run() {
				strings.add("A");
			}
		});
    	Thread t2=new Thread(new Runnable() {
    		
			@Override
			public void run() {
				strings.add("A");
				strings.add("B");
				strings.add("C");
				strings.add("D");
				strings.poll();
			}
		});
      t1.start();t2.start();
    }
}
