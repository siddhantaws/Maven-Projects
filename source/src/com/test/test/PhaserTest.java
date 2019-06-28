package com.test.test;

import com.test.concurrent.Phaser;

public class PhaserTest {
	static Phaser phaser =new Phaser(3);
	
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					phaser.arrive();
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
					phaser.arrive();
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
		
				}	
			}
		});
		t2.start();
				
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					phaser.arrive();
				}catch(Exception exception) {
					exception.printStackTrace();
				}finally {
					
				}	
			}
		});
		t3.start();
		
		System.out.println(phaser.awaitAdvance(1));
		System.out.println(phaser.awaitAdvance(2));
		System.out.println(phaser.awaitAdvance(3));
	}
}
