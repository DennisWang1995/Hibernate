package com.harold.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harold.hibernate.bean.Group;
import com.harold.hibernate.bean.User;


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


        // ???? LOL ??
        Group group = new Group();
        group.setGroupname("LOL_Group");


        // ??????
        User user1 = new User();
        user1.setUsername("Levis");
        user1.setPassword("111");

        User user2 = new User();
        user2.setUsername("Lee");
        user2.setPassword("222");

        // ?????????????????
        user1.setGroup(group);
        user2.setGroup(group);

        // ??????
        session.save(user1);
        session.save(user2);
        session.save(group);

        // ??????? session
        session.getTransaction().commit();
        session.close();
        sf.close();    
    }    
}

