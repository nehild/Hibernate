package com.tut.hibernat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        			//OR
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //cfg.configure("com/tut/hibernat/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        System.out.println(factory);
        
        Student st = new Student();
        st.setId(12);
        st.setName("meet");
        st.setCity("moti-monpari");
        System.out.println(st);
        
        // This getCurrentSession is already open in another request. 
        //Session session = factory.getCurrentSession();
        
        //That is create new session.
        Session session = factory.openSession();
        
        // First way 
//        session.beginTransaction();
//        session.save(st);
//        session.getTransaction().commit();
        
        // Second way
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        
        
        session.clear();
    }
}
