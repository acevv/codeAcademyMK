package org.test.hibernateDemoAnnotations;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateDemoAnnotations.entity.Employee.class);
			cfg.configure();

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			factory.close();
			session.close();

		} catch (HibernateException e) {

		}

	}
}
