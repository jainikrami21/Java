package com.hibernate.hibernatecore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
       // 1. data save
        
       //User u = new User(4,"nirav","rajasthan");
       //session.save(u);
        
//        //2. fetch Data
//        	User u = session.get(User.class,1);
//        	System.out.println(u);
        
        //3. Update
        //User u = new User(1,"Jainik","Ahmedabad");
        //session.update(u);
        
        //4. delete
        //User u = new User(2,"jay","delhi");
        //session.delete(u);
        
        tx.commit();
        session.close();
        sf.close();
    }
}
