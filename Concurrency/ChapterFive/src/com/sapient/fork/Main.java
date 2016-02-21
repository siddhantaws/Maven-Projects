package com.sapient.fork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main 
{
	public static void main(String[] args) 
	{
		/*try {
				RandomAccessFile accessFile=new RandomAccessFile(new File("D://myText.txt"), "r");
				long len=accessFile.length();
				System.out.println(len);
				accessFile.seek(2);
				byte b[]=new byte[5];
				accessFile.read(b, 0, 5);
				System.out.println("A"+new String(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ForkJoinPool forkJoinPool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		try {
				RandomAccessFile accessFile=new RandomAccessFile(new File("D://myText.txt"), "r");
				Task t=new Task(accessFile, 0l, accessFile.length());
				t=(Task)forkJoinPool.submit(t);
				try {
					System.out.println(t.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
