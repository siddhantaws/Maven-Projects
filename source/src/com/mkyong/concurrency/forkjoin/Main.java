package com.mkyong.concurrency.forkjoin;

public class Main {

    public static void main(String[] args) {

        System.out.println(ForkJoinAdd.startForkJoinSum(1_000_00));
		
    }

}