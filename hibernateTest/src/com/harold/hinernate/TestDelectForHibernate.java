package com.harold.hinernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hinernate.bean.User;

public class TestDelectForHibernate {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		StringBuilder hq = new StringBuilder();
		hq.append("from ").append(User.class.getName()).append(" where user_username=:name");
		Query query = session.createQuery(hq.toString());
		query.setString("name", "admin11");
		List<User> userlist= query.list();
		for (User user : userlist) {
			session.delete(user);
		}
		/*
		 * User user = new User();
		 * user.setId(5);
		 * session.delect(user);
		 * */
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
	}
}
