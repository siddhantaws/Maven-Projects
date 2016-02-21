package com.manh.spring3.aop;

public class HelloServiceImpl implements HelloService {

	@Override
	public void m1() {
		System.out.println("HelloServiceImpl->m1()");

	}

	@Override
	public void m2() throws Exception {
		System.out.println("HelloServiceImpl->m2()");
	}

	@Override
	public void am1() {
		System.out.println("HelloServiceImpl->am1()");

	}

	@Override
	public void am2() throws Exception {
		System.out.println("HelloServiceImpl->am2()");
	}

}
