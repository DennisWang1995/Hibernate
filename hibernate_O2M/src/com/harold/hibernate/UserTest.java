package com.harold.hibernate;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hibernate.bean.Group;
import com.harold.hibernate.bean.User;

public class UserTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		// ???? LOL ??
		Group group = new Group();
		group.setGroupname("LOL_Group");

		// ??????
		Set<User> users = new HashSet<User>();
		User user1 = new User();
		user1.setUsername("Levis");
		user1.setPassword("111");
		User user2 = new User();
		user2.setUsername("Lee");
		user2.setPassword("222");

		users.add(user1);
		users.add(user2);

		// LOL ???????????
		group.setUsers(users);

		// ??????
		for (User user : users) {
			session.save(user);
		}
		session.save(group);

		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
