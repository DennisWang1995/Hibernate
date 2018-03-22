package com.harold.ejb3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.ejb3.bean.User;

public class UserTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		User user =new User();
		user.setId(10);
		user.setUsername("awweweq");
		user.setPassword("123123");
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
	}
}
