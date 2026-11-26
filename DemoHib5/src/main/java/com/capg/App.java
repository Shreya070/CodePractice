package com.capg;



import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		
	
//		Configuration con = new Configuration().addResource("hibernate.properties").addAnnotatedClass(Student.class)
//				.addAnnotatedClass(StudentDetail.class);
		Configuration con = new Configuration();
		Properties properties =new Properties();
		try {
			
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		con.setProperties(properties);
		con.addAnnotatedClass(Student.class).addAnnotatedClass(StudentDetail.class);
	
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		 session.beginTransaction();

		Student student = new Student("shreya", "gupta", "shreya@gmail.com");

		StudentDetail studentDetail = new StudentDetail(" College", 20);

		student.setStudentDetail(studentDetail);

		

		session.save(student);

		session.getTransaction().commit();

		System.out.println("Transaction Successfully Completed.");
		
	}

}
