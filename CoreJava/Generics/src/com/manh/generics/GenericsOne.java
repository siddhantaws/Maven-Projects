package com.manh.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsOne 
{
	public static void main(String[] args) 
	{
		MyEmployeeUtil<Emp> empA = new MyEmployeeUtil<Emp>(new CompAEmp("Ram", 20000));
		MyEmployeeUtil<CompBEmp> empB = new MyEmployeeUtil<CompBEmp>(new CompBEmp("Krish", 30000));
		MyEmployeeUtil<CompAEmp> empC = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Nagesh", 20000));
		
	}
}
