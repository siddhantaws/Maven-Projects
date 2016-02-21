package com.manh.designpattern;

public class AbstractFactoryPatternDemo 
{
	public static void main(String[] args) 
	{
		//get shape factory
	    AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
	    //get an object of Shape Circle
	    Shape shape1 = shapeFactory.getShape("CIRCLE");
	    //call draw method of Shape Circle
	    shape1.draw();
	    //get an object of Shape Rectangle
	    Shape shape2 = shapeFactory.getShape("RECTANGLE");
	    //call draw method of Shape Rectangle
	    shape2.draw();
	    
	   //get color factory
	   AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
	   //get an object of Color Red
	   Color color1 = colorFactory.getColor("RED");
	   //call fill method of Red
	   color1.fill();
	}
}
