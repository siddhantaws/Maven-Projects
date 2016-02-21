package com.manh.localinner;

public class A 
{
	int ab=91;
	void show()
	{
		int abc=45;
		final int mn=23;
		class B
		{
			int ab=90;
			void display()
			{
				System.out.println("Display in local inner");
				System.out.println(ab);
				//System.out.println(abc);
				System.out.println(mn);
			}
		}
		B b1=new B();
		b1.display();
		ab=23;
		b1.display();
	}
}
