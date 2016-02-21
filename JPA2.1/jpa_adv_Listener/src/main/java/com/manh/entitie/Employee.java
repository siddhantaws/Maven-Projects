package com.manh.entitie;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@EntityListeners(com.manh.listener.AlertMonitor.class)
@Table(name="my_own_employee_table")
public class Employee {
    
    @Id
    private int id;
    @Column(name="my_name")
    private String name;
    @Column(name="my_salary")
    private long salary;

    // Embedded
    @Embedded
    private Address address;

    public Employee() {}
    public Employee(int id) {
        this.id = id;
    }


    // Listeners
    @PrePersist
    public void validateCreate() {
        System.out.println("----> Employee: validateCreate() gets called");
    }

    @PostLoad
    public void myPostLoad() {
        System.out.println("----> Employee: myPostLoad() gets called");
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public String toString() {
        return "Employee id: " + getId() + " name: " + getName() + " salary: " + getSalary();
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}

