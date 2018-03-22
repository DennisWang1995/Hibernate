package com.harold.hinernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hinernate.bean.User;

public class TestAdditionalForHibernate {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		User user = new User();
		// user.setId(1);
		// user.setUsername("admin");
		// user.setPassword("admin");
//		 user.setId(3);
//		 user.setUsername("admin");
//		 user.setPassword("12312412");

		 user.setId(5);
		 user.setUsername("admin11");
		 user.setPassword("123124122");

		session.save(user);
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
