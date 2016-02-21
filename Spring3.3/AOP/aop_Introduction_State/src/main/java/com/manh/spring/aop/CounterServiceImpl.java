package com.manh.spring.aop;

public class CounterServiceImpl implements CounterService {

    private int count = 0;

    public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}