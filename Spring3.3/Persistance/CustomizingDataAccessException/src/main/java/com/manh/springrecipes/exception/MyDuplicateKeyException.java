package com.manh.springrecipes.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class MyDuplicateKeyException extends DataIntegrityViolationException
{

	public MyDuplicateKeyException(String msg) 
	{
		super(msg);
	}
	public MyDuplicateKeyException(String msg,Throwable throwable)
	{
		super(msg, throwable);
	}
}
