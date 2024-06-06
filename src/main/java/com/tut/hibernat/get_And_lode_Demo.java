package com.tut.hibernat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class get_And_lode_Demo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//----- load method
		// This two line is create a object but that is not return object. That called Proxy Object 
		Student student =(Student) session.load(Student.class, 12);
		Student student1 =(Student) session.load(Student.class, 12);
		
		// That line called database. And execute the SQL query.
		System.out.println(student.getName());
		
		//----- get method
//		Address address =(Address) session.get(Address.class, 1);
//		System.out.println(address.getStreet() + " : " + address.getCity());
//		// session is stored data in Cache memory that's way execute only one time query. 
//		Address address1 =(Address) session.get(Address.class, 1);
//		System.out.println(address1.getStreet() + " : " + address1.getCity());
	}
}
