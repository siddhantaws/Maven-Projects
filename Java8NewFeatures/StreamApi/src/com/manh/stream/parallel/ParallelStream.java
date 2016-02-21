package com.manh.stream.parallel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream 
{
	public static void main(String[] args) 
	{
		int max = 5000000;
        int threashold = 50000;

        Date d1, d2;
        long elapsed_time;

        List<Integer> numbers = new ArrayList();
        for (int i = 0; i < max; i++)
            numbers.add(i);

        /* 
         * Measure the task without using parallelism
         */
        d1 = new Date();
        
     // Perform sequential filtering
        Stream<Integer> highNums = numbers.stream().filter(p -> p > threashold);

        d2 = new Date();
        elapsed_time = d2.getTime() - d1.getTime();
        System.out.println("Using sequential stream took " + elapsed_time
                + " milliseconds");

        /* 
         * Measure the task with using parallelism
         */
        d1 = new Date();

        // Perform parallel filtering 
        highNums = numbers.parallelStream().filter(p -> p > threashold);

        d2 = new Date();
        elapsed_time = d2.getTime() - d1.getTime();
        System.out.println("Using parallel stream took " + elapsed_time
                + " milliseconds");

	}
}
