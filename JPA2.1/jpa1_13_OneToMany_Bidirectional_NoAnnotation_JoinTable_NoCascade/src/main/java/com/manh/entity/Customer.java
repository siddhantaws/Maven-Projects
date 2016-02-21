package com.manh.entity;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.CascadeType.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer implements Serializable {

    @Id
    //@GeneratedValue
    private int id;
    
    private String name;

    // With @OneToMany annotation, you can specify cascade option
    @OneToMany(cascade=ALL)
    private List<Order> orders = new ArrayList<Order>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> newValue) {
        this.orders = newValue;
    }
}
