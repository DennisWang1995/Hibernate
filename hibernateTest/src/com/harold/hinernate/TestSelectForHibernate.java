package com.harold.hinernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hinernate.bean.User;

public class TestSelectForHibernate {
	public static void main(String[] args) {
	     Configuration configuration = new Configuration().configure();
	        @SuppressWarnings("deprecation")
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();

	        
	        StringBuilder hq = new StringBuilder();

	      
	        hq.append("from ").append( User.class.getName() );

	  
	        Query query = session.createQuery( hq.toString() );

	        
	        List<User> users = query.list();

	       
	        for (User user : users) {
	            System.out.println( user.getUsername() );

	        }

	        session.getTransaction().commit();
	        session.close();
	        sessionFactory.close();
	    }
	}
