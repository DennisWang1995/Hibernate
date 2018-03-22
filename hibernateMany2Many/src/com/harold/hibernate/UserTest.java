package com.harold.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hibernate.bean.*;

public class UserTest {

	public static void main(String[] args) {

		// ?? Hibernate ????
		Configuration cfg = new Configuration().configure();

		// ?? SessionFactory
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();

		// ?? Session
		Session session = sf.openSession();

		// ????
		session.beginTransaction();

		Set<Course> course = new HashSet<Course>();
		Course c1 = new Course();
		c1.setCou_name("Chinses");
		Course c2 = new Course();
		c2.setCou_name("English");
		Course c3 = new Course();
		c3.setCou_name("Math");
		course.add(c1);
		course.add(c2);
		course.add(c3);

		Set<Student> students = new HashSet<Student>();
		Student s1 = new Student();
		s1.setStu_name("Michael");
		Student s2 = new Student();
		s2.setStu_name("KangKang");
		Student s3 = new Student();
		s3.setStu_name("Jane");
		students.add(s1);
		students.add(s2);
		students.add(s3);

		c1.setStudents(students);
		c2.setStudents(students);
		c2.setStudents(students);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		// ??????? session
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
