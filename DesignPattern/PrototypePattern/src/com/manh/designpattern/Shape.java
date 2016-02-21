package com.manh.designpattern;

public abstract class Shape implements Cloneable 
{
	private String id;
	private String type;
	
	abstract void draw();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Object clone() 
	{
		Object obj=null;
		try {
			obj= super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
