package com.manh.wmos;

public class MyThread1 {

	public static void main(String[] args) 
	{
		Producer p1=new Producer(0);
		for(int i=0;i<3;i++)
		{
			Thread t1=new Thread(p1,"Thread1");
			t1.setPriority(5+i);
			t1.start();
		}
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (p1) {
			p1.status=1;
			p1.notify();
		}
	}
	static class Producer implements Runnable {
		public int status = 0;

		Producer(int status) {
			this.status = status;
		}

		@Override
		public void run() {
			synchronized (this) {
				while (status == 0) {

					try {
							System.out.println("Before Thread in Wait :"+Thread.currentThread().getName()+"\t"+Thread.currentThread().getPriority());
							wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("After Thread in Wait :"+Thread.currentThread().getName()+"\t"+Thread.currentThread().getPriority());
			}
		}
	}
}
