package com.sapient.executor;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer>
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
	public Integer call() throws Exception 
	{
		return calculate(file, start, end);
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
}
