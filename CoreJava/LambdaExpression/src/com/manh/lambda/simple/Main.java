package com.manh.lambda.simple;

class Main {
	
	public static void main(String[] args) {
		
		// Anonymous inner class.
		MyFunctionalInterface myObject1 = new MyFunctionalInterface() {
			@Override
			public void mySingleAbstractMethod() {
				MyClass.existingStaticMethod();
			}
		};
		myObject1.mySingleAbstractMethod();
		
		// Lambda expression
		MyFunctionalInterface myObject2 = () -> MyClass.existingStaticMethod();
		myObject2.mySingleAbstractMethod();
		
		// Method reference - using static method of a class
		MyFunctionalInterface myObject3 = MyClass::existingStaticMethod;
		myObject3.mySingleAbstractMethod();		
		
	}
}
