package com.sapient.executor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main 
{
	public static void main(String[] args) 
	{
		ExecutorService service =Executors.newFixedThreadPool(3);
		try {
				RandomAccessFile accessFile=new RandomAccessFile(new File("D://myText.txt"), "r");
				long len=accessFile.length();
				List<Task> l=new ArrayList<Task>();
				for(int i=0;i<len;i++)
				{
					l.add(new Task(accessFile, i , i=i+9));
				}
				List<Future<Integer>> l1=service.invokeAll( l);
				int count=0;
				for(Future<Integer> f1:l1)
				{
					count=count+f1.get();
				}
				System.out.println("Total Count"+count);
		} catch (IOException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
