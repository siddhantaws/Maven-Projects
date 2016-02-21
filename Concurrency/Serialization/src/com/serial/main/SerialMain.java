package com.serial.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.manh.serial.Address;
import com.manh.serial.Student;

public class SerialMain 
{
	public static void main(String[] args) 
	{
		Student student=new Student(1, "Siddhanta");
		Address address=new Address(1, "4th Street");
		student.setAddress(address);
		
		try {
			FileOutputStream fout = new FileOutputStream("D:\\f.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(student);
			out.flush();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	}
}
