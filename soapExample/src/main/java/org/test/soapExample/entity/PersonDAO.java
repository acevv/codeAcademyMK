package org.test.soapExample.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonDAO {

	static SessionFactory factory;
	static Transaction tx = null;

	public static Session initDb() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(org.test.soapExample.entity.Person.class);

		factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();

		return session;
	}

	public static String openSession(Person person) {

		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();

			cfg.addAnnotatedClass(org.test.soapExample.entity.Person.class);

			factory = cfg.configure().buildSessionFactory();

			Session session = factory.openSession();

			tx = session.beginTransaction();

			session.save(person);

			tx.commit();

			session.close();

			factory.close();
			return "Successfully added in DataBase!";

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
			return "Failed to add to DataBase!";
		}

	}

	public static List<Person> getAllFromDB() {
		List<Person> result = new ArrayList<Person>();
		Session s = initDb();
		try {
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM Person AS p").list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			System.out.println(e);
		}

		return result;

	}

	public static Person findByID(Integer id) {
		List<Person> result = new ArrayList<Person>();

		Session s = initDb();
		try {
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM Person AS p").list();
			result = s.createNativeQuery("SELECT * FROM Person WHERE id=" + id + ";", Person.class).list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			System.out.println(e);
		}

		return result.get(0);

	}
	
}
