package com.manh.spring.aop;

public class ReverseNameServiceImpl implements ReverseNameService {
		
	public String reverseName(String name) {
		String reverse = new StringBuffer(name).
		reverse().toString(); 
		
		return reverse;
    }
}