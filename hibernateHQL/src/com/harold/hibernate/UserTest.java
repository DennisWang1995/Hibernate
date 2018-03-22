package com.harold.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.harold.hibernate.bean.User;

public class UserTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		
//		User user = new User();
//		user.setId(1);
//		user.setUsername("Admin");
//		user.setPassword("admin");
//		session.save(user);
		// 1. ordinary select
			Query query = session.createQuery(" from User as u");
		
		//2.condition
		//Query query = session.createQuery(" from User as u where u.username = ?");
		//query.setParameter(0, "Jack");

		//3.origin select
		// SQLQuery sqlQuery =
		// session.createSQLQuery("select * from user_info").addEntity(User.class);
		//
		// List<User> list=sqlQuery.list();
		
		//4.criteria 
//		Criteria query = session.createCriteria(User.class);
//		Criteria cq = Restrictions.between("id", 1, 3);
//		Criteria cc = Restrictions.idEq(2);
		for (User user : list) {
			System.out.println(user.getUsername()+", password: "+user.getPassword());
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
