package com.manh.lambda.variable;

class Main {

	public static void main(String[] args) {
	
		// Anonymous inner class.
		MyFunctionalInterface myObject1 = new MyFunctionalInterface() {
			@Override
			public void mySingleAbstractMethod(String name, int age) {
				MyClass.existingStaticMethod(name, age);
			}
		};
		myObject1.mySingleAbstractMethod("Jon", 88);

		// Lambda expression
		MyFunctionalInterface myObject2 = 
				(name, age) -> MyClass.existingStaticMethod(name, age);
		myObject2.mySingleAbstractMethod("Jon", 77);

		// Method reference
		MyFunctionalInterface myObject3 = MyClass::existingStaticMethod;
		myObject3.mySingleAbstractMethod("Jon", 66);
		//myObject3.mySingleAbstractMethod("Tom"); // Compile error

	}
}
