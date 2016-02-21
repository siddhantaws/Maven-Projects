package com.manh.instance;

public class A
{
	void show()
	{
		System.out.println("Show of outer Class");
		System.out.println(ab);
		B b=new B();
		b.showinner();
	}
	
	protected class B
	{
		int xy=6;
		void showinner()
		{
			System.out.println("Show of Inner Class");
			System.out.println(ab);
			System.out.println(mn);
			System.out.println(xy);
		}
		/*public void static aa(){}*/
		
	}
	int ab=10;
	static int mn=89;
}
