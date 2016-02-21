package com.manh.exception;

public class MyError 
{	
		public static void main(String[] args) 
		{
			MyError error=new MyError();
			try{
				error.showError();	
			}catch(Error exception)
			{
				System.out.println("Error");
			}finally{
				System.out.println(1);
			}
			
		}
		public void showError()
		{
			if(1==1)
				throw new Error();
		}
}
