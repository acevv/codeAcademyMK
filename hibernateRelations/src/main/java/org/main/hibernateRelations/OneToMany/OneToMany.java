package org.main.hibernateRelations.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.hibernateRelations.OneToMany.entity.Answer;
import org.main.hibernateRelations.OneToMany.entity.Question;

public class OneToMany {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.main.hibernateRelations.OneToMany.entity.Answer.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.OneToMany.entity.Question.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			Question q = new Question("What is Java?");
			Answer a = new Answer("Java is a programming language", "Mite");
			Answer a2 = new Answer("Java is a platforn", "Trajce");
			Answer a3 = new Answer("Java is cool", "Vlatko");

			List<Answer> answersList = new ArrayList<Answer>();
			answersList.add(a);
			answersList.add(a2);
			answersList.add(a3);
			q.setAnswers(answersList);

			session.persist(q);
			tx.commit();

			factory.close();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
