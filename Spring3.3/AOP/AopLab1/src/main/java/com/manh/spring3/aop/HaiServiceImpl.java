package com.manh.spring3.aop;

public class HaiServiceImpl implements HaiService {

	@Override
	public void m1() {
		System.out.println("HaiServiceImpl->m1()");

	}

	@Override
	public void m2() {
		System.out.println("HaiServiceImpl->m2()");

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
