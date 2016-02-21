package com.manh.staticinner;

public class A 
{
	int ab=90;
	static int xy=12;
	void display()
	{
		System.out.println("Dsiaply Outer Class");
		B b =new B(); 
	}
	static class B
	{
		int mn=89;
		static int bn=67;
		void show()
		{
			System.out.println("Show of Inner Class");
			//System.out.println(ab);
			System.out.println(xy);
		}
	} 
}
