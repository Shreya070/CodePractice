package com.capge.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
       
        Student st =new Student();
        st.setId(101);
        st.setFirstName("rashi");
        st.setLastName("Dixit");
        Configuration con =new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg =new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf =con.buildSessionFactory(reg);
        Session session= sf.openSession();
        Transaction tx =session.beginTransaction(); 
       session.save(st);
       // st = (Student) session.get(Student.class, 102);
        tx.commit();
        System.out.println(st);
    }
}
