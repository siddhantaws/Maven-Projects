package com.manh.enums;

public class EnumSwitchCase 
{
	Day day;
    public EnumSwitchCase(Day day) 
    {
        this.day = day;
    }
    public void tellItLikeItIs() 
    {
       switch(day)
       {
       		case MONDAY: 
       			System.out.println("Mondays are bad.");
       			break;
       		case THURSDAY:
       			System.out.println("THURSDAY are bad.");
                break;
            default :
            	System.out.println("All are bad.");
            	break;
       }
    }
    public static void main(String[] args) 
    {
    	EnumSwitchCase firstDay = new EnumSwitchCase(Day.MONDAY);
        firstDay.tellItLikeItIs();
        for(LavelParams d:LavelParams.values())
        {
        	System.out.println(d.name()+"\t"+d.ordinal());
        }
        System.out.println(Day.valueOf(Day.MONDAY.toString()));;
	}
}
