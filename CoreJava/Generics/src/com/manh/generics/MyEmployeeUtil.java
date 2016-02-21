package com.manh.generics;

public class MyEmployeeUtil<T extends Emp>
{
	private T emp;
    
    public MyEmployeeUtil(T obj){
        emp = obj;
    }
     
    public int getSalary(){
        return emp.getSalary();
    }

    public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp)
    {
        if(emp.getSalary() == otherEmp.getSalary())
        {
            return true;
        }
        return false;
    }
}
class Emp{
    
    private String name;
    private int salary;
     
    public Emp(String name, int sal){
        this.name = name;
        this.salary = sal;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
class CompAEmp extends Emp{
    
    public CompAEmp(String nm, int sal){
        super(nm, sal);
    }
}
 
class CompBEmp extends Emp{
     
    public CompBEmp(String nm, int sal){
        super(nm, sal);
    }
}
