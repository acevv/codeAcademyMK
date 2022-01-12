package org.test.company.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.test.company.entity.Departmnet;
import org.test.company.entity.Project;

public class CompanyServiceImpl implements CompanyService {

	static SessionFactory factory;

	public void openSession() {
		Transaction tx = null;

		try {

			Configuration cfg = new Configuration();

//			cfg.addAnnotatedClass(org.test.company.entity.Employee.class);
//			cfg.addAnnotatedClass(org.test.company.entity.Departmnet.class);
//			cfg.addAnnotatedClass(org.test.company.entity.Project.class);
//			cfg.addAnnotatedClass(org.test.company.entity.Dependent.class);
//			cfg.addAnnotatedClass(org.test.company.entity.WorksOn.class);
//			cfg.addAnnotatedClass(org.test.company.entity.DepartmentLocations.class);
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

//			addDepartment(session);

			tx = session.beginTransaction();
			addProject(session);
			System.out.println("Success!");

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("FAIL!");
			System.out.println(e);
		}

	}

	private void addDepartment(Session session) {
		Transaction tx = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		try {

			tx = session.beginTransaction();
			date = df.parse("1988-05-22");
			Departmnet d = new Departmnet("Research", 5, 333445555, date);
			session.save(d);
			date = df.parse("1995-01-01");
			Departmnet d1 = new Departmnet("Administration", 4, 987654321, date);
			session.save(d1);
			date = df.parse("1981-06-19");
			Departmnet d2 = new Departmnet("Headquarters", 1, 888665555, date);
			session.save(d2);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	public void addProject(Session session) {
//		Transaction tx = null;

		try {
//			tx = session.beginTransaction();

//			String hql = "SELECT d FROM department d WHERE d.number=:depId";
			List list = session.createQuery("FROM .department").list();
//			Query query = session.createQuery(hql);
//			List<Departmnet> departments = query.setParameter("depId", 5).list();

			Project p = new Project();
			p.setpName("ProductX");
			p.setpNumber(1);
			p.setpLocation("Bellaire");

			List<Project> projects = new ArrayList<Project>();
			projects.add(p);
//			for (Departmnet d : departments) {
//				d.setProjects(projects);
//				session.save(d);
//			}
			session.save(p);

//			tx.commit();

		} catch (HibernateException e) {
//			tx.rollback();
			System.out.println(e);
		}

	}

}
