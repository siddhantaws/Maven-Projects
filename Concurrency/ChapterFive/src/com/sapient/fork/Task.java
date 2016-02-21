package com.sapient.fork;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Integer>
{
	
	private RandomAccessFile file;
	
	private long start ;
	
	private long end;
	
	public Task(RandomAccessFile file ,long start ,  long end)
	{
		this.file=file;
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected Integer compute() 
	{
		if(end-start<=9)
			return calculate(file , start ,  end);
		else
		{
			int count=0;
			try {
					long len=file.length();
					List<Task> l=new ArrayList<Task>();
					for(int i=0;i<len;i++)
					{
						l.add(new Task(file, i , i=i+9));
					}
					invokeAll(l);
					count = groupResult(l);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		}
		
	}
	
	protected int getCount(byte by[])
	{
		int count=0;
		for(int i=0;i<by.length;i++)
		{
			if((char)by[i]=='A')
				count++;
		}
		return count;
	}
	
	public int calculate(RandomAccessFile file ,long start ,  long end)
	{
		byte by[]=null;
		synchronized(file)
		{
			try {
					file.seek(start);
					by=new byte[(int)(end-start)];
					file.read(by, 0, by.length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return getCount(by);
	}
	
	public int groupResult(List<Task> t1)
	{
		int count =0;
		for(Task t:t1)
		{
			try {
				count=count+t.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
}
