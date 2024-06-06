package com.tut.hibernat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        			//OR
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //cfg.configure("com/tut/hibernat/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        System.out.println(factory);
        
        //-----------Creating object of Student class
        
        Student st = new Student();
        st.setId(12);
        st.setName("meet");
        st.setCity("moti-monpari");
        System.out.println(st);
        
        
      //-----------Creating object of Student class
        
        Address ad = new Address();
        ad.setAddedDate(new Date());
        ad.setCity("Ahmedabad");
        ad.setStreet("street1");
        ad.setX(122025.5214852);
        ad.setOpen(true);
        //  Reading image 
        FileInputStream fis = new FileInputStream("src/main/java/nehil.jpeg");
        byte[] data = new byte[fis.available()];
        ad.setImage(data);
        
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
        session.save(ad);
        tx.commit();
        
        
        session.clear();
    }
}
