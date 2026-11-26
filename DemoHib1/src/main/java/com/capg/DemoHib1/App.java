package com.capg.DemoHib1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Laptop laptop =new Laptop();
       laptop.setLid(102);
       laptop.setLname("Dell");
       
       Student s =new Student();
       s.setName("shre");
       s.setRollno(2);
       s.setMarks(50);
       s.getLaptop().add(laptop);
       laptop.getStudent().add(s);
       Configuration con =new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry reg =new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf =con.buildSessionFactory(reg);
       Session session= sf.openSession();
       session.beginTransaction(); 
       session.save(laptop);
      session.save(s);
    session.getTransaction().commit();
    }
}
