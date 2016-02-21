package com.manh.hibernate.client;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.manh.hibernate.Person;
import com.manh.hibernate.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        // Set up database tables
        HibernateUtil.droptable("drop table person");
        HibernateUtil.setup("create table person ( id int, name VARCHAR(20))");

        // Create SessionFactory and Session object
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();
        System.out.println("----> Session 1 is created");

        Person p1 = null;
        Person p2 = null;
        Person p1_merged = null;

        Object id1 = null;
        Object id2 = null;

        // Perform life-cycle operations under a transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create a Person object and save it
            p1 = new Person();  //transient state
            p1.setName("Sang Shin");
            // Persist the given transient instance, first assigning a 
            // generated identifier.
            session.save(p1);          // persistent state

            id1 = session.getIdentifier(p1);
            System.out.println("Session 1, id1 = " + id1);

            // Create another Person object and save it.
            p2 = new Person();  //transient state
            p2.setName("Young Shin");
            session.save(p2);          // persistent state

            id2 = session.getIdentifier(p2);
            System.out.println("Session 1, id2 = " + id2);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        System.out.println("----> Session 1 is closed and objects in detached state");

        // p1 and p2 are now in detached state.
        // You will experience  Session is closed! exception
        // if you try the following line.
        // id1 = session.getIdentifier(p1);

        // Create a new session
        session = sessions.openSession();
        System.out.println("----> Session 2 is created");
        try {
            tx = session.beginTransaction();

            // p1 is now in detached state - there is no session it is associated with
            p1.setName("Sang Shin2");   // detached state
            
            // Copy the state of the given object onto the persistent object 
            // with the same identifier. If there is no persistent instance 
            // currently associated with the session, it will be loaded. 
            // Return the persistent instance. If the given instance is 
            // unsaved, save a copy of and return it as a newly persistent 
            // instance. The given instance does not become associated with 
            // the session.
            System.out.println("About to perform merge...");
            p1_merged = (Person) session.merge(p1);          // p1 remains to be detached
                                                             // p1_merged is persistent state
            System.out.println("After the merge....");

            id1 = session.getIdentifier(p1_merged);
            System.out.println("Session 2, id1 = " + id1);

            p2.setName("Young Shin3"); // detached state
            // Persist the given transient instance, first assigning a 
            // generated identifier.
            session.save(p2);          // persistent state in another session

            id2 = session.getIdentifier(p2);
            System.out.println("Session 2, id2 = " + id2);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("----> Session 2 is closed");


        // Display tables
        HibernateUtil.checkData("select * from person");

    }
}
