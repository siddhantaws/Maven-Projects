package com.manh.spring3.aop;

public class HaiServiceImpl implements HaiService {

	@Override
	public String m1(String s1,String s2) {
		System.out.println("HaiServiceImpl->m1()");
		return s1+s2;
	}

	@Override
	public String m2(String s1,String s2) 
	{
		System.out.println("HaiServiceImpl->m2()");
		if(1==1)
			throw new RuntimeException();
		return s1+s2;
	}

	@Override
	public void am1() {
		System.out.println("HaiServiceImpl->am1()");

	}

	@Override
	public void am2() {
		System.out.println("HaiServiceImpl->am2()");

	}

}
