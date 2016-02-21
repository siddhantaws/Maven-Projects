package com.manh.enums;

public enum LavelParams 
{
	HIGH  (3),  //calls constructor with value 3
    MEDIUM(2),  //calls constructor with value 2
    LOW   (1) ;  //calls constructor with value 1
    
    private final int levelCode;
	
	private LavelParams(int levelCode) 
	{
        this.levelCode = levelCode;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
