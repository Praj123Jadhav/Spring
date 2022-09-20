package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// step-1
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// step-2
		SessionFactory sf = configuration.buildSessionFactory();
		// step-3
		Session s = sf.openSession();
		
		//step-4
		Transaction t=s.beginTransaction();
		Student student=new Student(); //Transient state
		//how to set the value into student object
		//student.setId(15);
		student.setName("shubham");
		student.setCity("pune");
		student.setMobile("7575858595");
		
		s.save(student); //persistent
		t.commit();
		System.out.println("Record is saved.....");
		//s.evict(student);//detached state
		
		
	}
}
