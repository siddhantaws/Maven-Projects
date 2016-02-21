package com.manh.lambda.argument;

class Main {

	public static void main(String[] args) {
		
		// Lambda expression
		yourMethod((name, age) -> MyClass.existingStaticMethod(name, age) );
		
		// Method reference
		yourMethod(MyClass::existingStaticMethod);

	}
	
	public static void yourMethod(MyFunctionalInterface x) {
		x.mySingleAbstractMethod("Jon", 11);
	}
	
}
