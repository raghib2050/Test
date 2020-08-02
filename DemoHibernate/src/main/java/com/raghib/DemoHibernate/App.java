package com.raghib.DemoHibernate;

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
        Alien obj = new Alien();
        obj.setAid(102);
        obj.setName("Mashkoor");
        obj.setColor("Green");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction txn = session.beginTransaction();
        //session.save(obj);
        
        obj = (Alien) session.get(Alien.class, 102);
        
        txn.commit();
        
        System.out.println(obj);
        
    }
}
