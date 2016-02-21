package com.serial.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.manh.serial.Student;

public class DeserialMain {
	public static void main(String[] args) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\f.txt"));
			Student s = (Student) in.readObject();
			System.out.println(s);
		} catch (IOException  | ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}
