package org.main.hibernateRelations.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.hibernateRelations.manyToMany.entity.Answer;
import org.main.hibernateRelations.manyToMany.entity.Question;

public class ManyToMany {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.main.hibernateRelations.manyToMany.entity.Answer.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.manyToMany.entity.Question.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// -------------------Question 1
			Question q1 = new Question("What is JAVA?");

			Answer a1_1 = new Answer("A platform", "Mite");
			Answer a1_2 = new Answer("A language", "Trajce");
			Answer a1_3 = new Answer("Coffee", "Pero");

			List<Answer> a_list = new ArrayList<Answer>();
			a_list.add(a1_1);
			a_list.add(a1_2);
			a_list.add(a1_3);

			q1.setAnswers(a_list);

			// --------------------Question 2
			Question q2 = new Question("What is compiler?");

			Answer a2_1 = new Answer("Compiler is translator of source to byte code", "Ognen");
			Answer a2_2 = new Answer("Compiler is a translator", "Dimitar");

			List<Answer> a2_list = new ArrayList<Answer>();

			a2_list.add(a2_1);
			a2_list.add(a2_2);

			q2.setAnswers(a2_list);

			session.persist(q1);
			session.persist(q2);

			tx.commit();
			session.close();
			factory.close();

		} catch (HibernateException e) {
			System.out.println(e);
		}

	}

}
