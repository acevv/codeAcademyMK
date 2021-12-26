package org.main.hibernateRelations.oneToOne;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.hibernateRelations.oneToOne.entity.Address;
import org.main.hibernateRelations.oneToOne.entity.Student;

public class OneToOne {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {

			Configuration cfg = new Configuration();

			cfg.addAnnotatedClass(org.main.hibernateRelations.oneToOne.entity.Student.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.oneToOne.entity.Address.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			tx = session.beginTransaction();

			// One To One mapping of entities
			Student s = new Student();
			s.setName("Aleksandar");
			s.setSurName("Acev");

			Address ad = new Address();
			ad.setSreet("Mladinska");
			ad.setCity("Strumice");
			ad.setNumber(16);

			// se povrzuvaat dvata objekti no se pusta samo Student
			ad.setStudent(s);
			s.setAddress(ad);
			// se commita samo Student
//			session.persist(s);  

			String hql = "SELECT s FROM Student s WHERE s.id=:stid";
			Query query = session.createQuery(hql);

			List<Student> res = query.setParameter("stid", 1L).getResultList();
			System.out.println(res.get(0).getSurName());

			Address a = res.get(0).getAddress();
			System.out.println(a.getCity());

//			List<Student> res2 = session.createNamedQuery(("SELECT s FROM Student AS s").list);

			tx.commit();

			factory.close();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
