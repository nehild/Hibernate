package com.tut.hibernat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student = new Student();
		student.setId(12);
		student.setName("nehil");
		student.setCity("Ahmedabad");
		
		Cretificate cretificate = new Cretificate();
		cretificate.setCourse("Andrid");
		cretificate.setDuration("2 months");
		
		student.setCerti(cretificate);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	
		factory.close();
	}
}
