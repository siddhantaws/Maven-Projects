package com.manh.exception;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class MyOwnException 
{
	public static void main(String[] a)
	{
        try{
            MyOwnException.myTest(null);
        } catch(MyAppException mae){
            System.out.println("Inside catch block: "+mae.getMessage());
        }
    }
     
    static void myTest(String str) throws MyAppException
    {
    	
        if(str == null){
            throw new MyAppException("String val is null");
        }
    }
}
