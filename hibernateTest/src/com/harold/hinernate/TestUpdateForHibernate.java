package com.harold.hinernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hinernate.bean.User;

public class TestUpdateForHibernate {
	public static void main(String[] args) {
		  Configuration configuration = new Configuration().configure();
	        @SuppressWarnings("deprecation")
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        StringBuilder hq = new StringBuilder();        
	        hq.append("from ").append(User.class.getName()).append(" where user_username=:name");
	        Query query = session.createQuery(hq.toString());        
	        query.setString("name","admin" ); 
	        List<User> users = query.list();
	        for (User user : users) {            
	            user.setPassword("123-user");
	            session.update(user);
	        }
	        /*
	         * User user= new User();
	         * user.setInt(2);
	         * user.setUsername("user1");
	         * user.setPassword("123-user");
	         * */
	        session.getTransaction().commit();
	        session.close();
	        sessionFactory.close();
	    }
	}
