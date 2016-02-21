package com.manh.unsafe;

import java.lang.reflect.Field;
import java.util.Random;

import sun.misc.*;

public class Lab1 {
	public static void showBytes() {
		try {

			Unsafe unsafe = getUnsafe();
			// Writing to a memory - MAX VALUE Byte
			byte value = Byte.MAX_VALUE;
			long bytes = 1;
			long memoryAddress = unsafe.allocateMemory(bytes);
			unsafe.putAddress(memoryAddress, value);

			// Output the value written and the memory address
			System.out.println("[Byte] Writing " + value + " under the " + memoryAddress + " address.");
			long readValue = unsafe.getAddress(memoryAddress);
			// Output the value from
			System.out.println("[Byte] Reading " + readValue + " from the " + memoryAddress + " address.");
			unsafe.freeMemory(memoryAddress);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static void showLong() {
		try {
			Unsafe unsafe = getUnsafe();
			// Writing to a memory - MAX VALUE of Long
			long value = Long.MAX_VALUE;
			long bytes = Long.SIZE;

			long memoryAddress = unsafe.allocateMemory(bytes);
			// Write value to the allocated memory
			unsafe.putLong(memoryAddress, value);

			// Output the value written and the memory address
			System.out.println("[Long] Writing " + value + " under the " + memoryAddress + " address.");

			// Read the value from the memory
			long readValue = unsafe.getLong(memoryAddress);
			// Output the value from
			System.out.println("[Long] Reading " + readValue + " from the " + memoryAddress + " address.");

			// C style! Release the Kraken... Memory!! :)
			unsafe.freeMemory(memoryAddress);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void showDontFreeMemory() {
		
			for (int t = 0; t < 100; t++) {
				new Thread() {
					public void run() {
						System.out.println("Thread " + Thread.currentThread().getName() + " start!");
						for (int i = 0; i < 1000000; i++) {
							try {
									Unsafe unsafe = getUnsafe();
									// Writing random Long to a memory
									long value = new Random().nextLong();
									long bytes = Long.SIZE;
									// Allocate given memory size
									long memoryAddress = unsafe.allocateMemory(bytes);
									// Write value to the allocated memory
									unsafe.putLong(memoryAddress, value);
									// Read the value from the memory
									long readValue = unsafe.getLong(memoryAddress);
									
									
							}catch(Exception exception)
							{
								exception.printStackTrace();
							}
						}
					}
				};
			}
		
	}

	private static Unsafe getUnsafe() throws Exception {
		// Get the Unsafe object instance
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		return (sun.misc.Unsafe) field.get(null);
	}
}
