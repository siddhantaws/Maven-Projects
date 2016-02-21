package com.manh.spring.aop;

public class ReverseMessageServiceImpl implements ReverseMessageService {
		
	public String reverseMessage(String message) {
		String reverse = new StringBuffer(message).
		reverse().toString(); 
		
		return reverse;
    }
}