package org.main.hibernateRelations.manyToOne;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.hibernateRelations.manyToOne.entity.Department;
import org.main.hibernateRelations.manyToOne.entity.Employee;
import org.main.hibernateRelations.manyToOne.entity.Project;

public class ManyToOne {

	static SessionFactory factory;

	public static void main(String[] args) {

		Transaction tx = null;

		try {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.main.hibernateRelations.manyToOne.entity.Department.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.manyToOne.entity.Employee.class);
			cfg.addAnnotatedClass(org.main.hibernateRelations.manyToOne.entity.Project.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// Many to one relation

			Project p1 = new Project("IoT", "About IoT project");
			session.save(p1);

			Department d1 = new Department("IoT", 10);
			d1.setProject(p1);
			session.save(d1);

			Date date = new Date(System.currentTimeMillis());
			
			Employee e1 = new Employee("Ognen Ilioski", 9999, date);
			e1.setDepartment(d1);
			
			Employee e2 = new Employee("Vlatko Doncev", 9999, date);
			e1.setDepartment(d1);

			session.save(e1);
		
			tx.commit();

			factory.close();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}
}
