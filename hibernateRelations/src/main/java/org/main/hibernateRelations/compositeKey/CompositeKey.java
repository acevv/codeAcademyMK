package org.main.hibernateRelations.compositeKey;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.hibernateRelations.compositeKey.entity.Student;
import org.main.hibernateRelations.compositeKey.entity.StudentId;

public class CompositeKey {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.main.hibernateRelations.compositeKey.entity.Student.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.compositeKey.entity.StudentId.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			tx = session.beginTransaction();

			StudentId  sid = new StudentId(1, "9667");
			Student s1 = new Student(sid, "Aleksandar");
			session.save(s1);
			tx.commit();

			session.close();
			factory.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
