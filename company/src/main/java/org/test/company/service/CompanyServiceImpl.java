package org.test.company.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.test.company.entity.DepartmentLocations;
import org.test.company.entity.Departmnet;
import org.test.company.entity.Dependent;
import org.test.company.entity.Employee;
import org.test.company.entity.Project;
import org.test.company.entity.WorksOn;

public class CompanyServiceImpl implements CompanyService {

	static SessionFactory factory;

	public Session openSession() {

		Session session = null;
		try {

			Configuration cfg = new Configuration();

			cfg.addAnnotatedClass(org.test.company.entity.Employee.class);
			cfg.addAnnotatedClass(org.test.company.entity.Departmnet.class);
			cfg.addAnnotatedClass(org.test.company.entity.Project.class);
			cfg.addAnnotatedClass(org.test.company.entity.Dependent.class);
			cfg.addAnnotatedClass(org.test.company.entity.WorksOn.class);
			cfg.addAnnotatedClass(org.test.company.entity.DepartmentLocations.class);
			factory = cfg.configure().buildSessionFactory();
			session = factory.openSession();

		} catch (HibernateException e) {
			System.out.println("FAIL!");
			System.out.println(e);
		}

		return session;
	}

	public void addData() {

		Transaction tx = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {

			Session session = openSession();

			tx = session.beginTransaction();

			date = df.parse("1988-05-22");
			Departmnet d1 = new Departmnet("Research", 5, 333445555, date);

			date = df.parse("1995-01-01");
			Departmnet d2 = new Departmnet("Administration", 4, 987654321, date);

			date = df.parse("1981-06-19");
			Departmnet d3 = new Departmnet("Headquarters", 1, 888665555, date);

			session.save(d1);
			session.save(d2);
			session.save(d3);

			Project p1 = new Project("ProductX", 1, "Bellaire", d1);
			Project p2 = new Project("ProductY", 2, "Sugarland", d1);
			Project p3 = new Project("ProductZ", 3, "Houston", d1);
			Project p4 = new Project("Computerization", 10, "Stafford", d2);
			Project p5 = new Project("Reorganization", 20, "Houston", d3);
			Project p6 = new Project("Newbenefits", 30, "Stafford", d2);

			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);
			session.save(p5);
			session.save(p6);

			DepartmentLocations dl1 = new DepartmentLocations(d3, "Houston");
			DepartmentLocations dl2 = new DepartmentLocations(d2, "Stafford");
			DepartmentLocations dl3 = new DepartmentLocations(d1, "Bellaire");
			DepartmentLocations dl4 = new DepartmentLocations(d1, "Sugarland");
			DepartmentLocations dl5 = new DepartmentLocations(d1, "Houston");

			session.save(dl1);
			session.save(dl2);
			session.save(dl3);
			session.save(dl4);
			session.save(dl5);

			date = df.parse("1965-01-09");
			Employee e1 = new Employee("John", 'B', "Smith", 123456789, date, "731 Fondren,Houston, TX", 'M', 30000,
					333445555);
			e1.setDepartment(d1);

			date = df.parse("1955-12-08");
			Employee e2 = new Employee("Franklin", 'T', "Wong", 333445555, date, "683 Voss,Houston, TX", 'M', 40000,
					888665555);
			e2.setDepartment(d1);

			date = df.parse("1968-01-19");
			Employee e3 = new Employee("Alicia", 'J', "Zaleya", 999887777, date, "332 Castle,Spring, TX", 'F', 25000,
					987654321);
			e3.setDepartment(d2);

			date = df.parse("1941-06-15");
			Employee e4 = new Employee("Jennifer", 'S', "Wallace", 987654321, date, "291 Berry,Houston, TX", 'F', 43000,
					888665555);
			e4.setDepartment(d2);

			date = df.parse("1962-09-15");
			Employee e5 = new Employee("Ramesh", 'K', "Narayan", 666884444, date, "975 Fire Oak,Houston, TX", 'M',
					38000, 33344555);
			e5.setDepartment(d1);

			date = df.parse("1972-07-31");
			Employee e6 = new Employee("Joyce", 'A', "English", 453453453, date, "563 Rice,Houston, TX", 'F', 25000,
					333445555);
			e6.setDepartment(d1);

			date = df.parse("1969-03-29");
			Employee e7 = new Employee("Ahmad", 'V', "Jabbar", 987987987, date, "980 Dallas,Houston, TX", 'M', 25000,
					987654321);
			e7.setDepartment(d2);

			date = df.parse("1937-11-10");
			Employee e8 = new Employee("James", 'E', "Borg", 888665555, date, "450 Stone,Houston, TX", 'M', 55000, 0);
			e8.setDepartment(d3);

			session.save(e1);
			session.save(e2);
			session.save(e3);
			session.save(e4);
			session.save(e5);
			session.save(e6);
			session.save(e7);
			session.save(e8);

			date = df.parse("1986-04-05");
			Dependent de1 = new Dependent('F', date, "Daughter", e2, "Alice");

			date = df.parse("1983-10-25");
			Dependent de2 = new Dependent('M', date, "Son", e2, "Theodore");

			date = df.parse("1958-05-03");
			Dependent de3 = new Dependent('F', date, "Spouse", e2, "Joy");

			date = df.parse("1942-02-28");
			Dependent de4 = new Dependent('M', date, "Spouse", e4, "Abner");

			date = df.parse("1988-01-04");
			Dependent de5 = new Dependent('F', date, "Son", e1, "Michael");

			date = df.parse("1988-12-30");
			Dependent de6 = new Dependent('F', date, "Daughter", e1, "Alice");

			date = df.parse("1967-05-05");
			Dependent de7 = new Dependent('F', date, "Spouse", e1, "Elisabeth");

			session.save(de1);
			session.save(de2);
			session.save(de3);
			session.save(de4);
			session.save(de5);
			session.save(de6);
			session.save(de7);

			WorksOn wo1 = new WorksOn(e1, p1, 40.1);
			WorksOn wo2 = new WorksOn(e1, p2, 11);
			WorksOn wo3 = new WorksOn(e5, p3, 22);
			WorksOn wo4 = new WorksOn(e6, p1, 33.3);
			WorksOn wo5 = new WorksOn(e6, p2, 44.4);
			WorksOn wo6 = new WorksOn(e2, p2, 10);
			WorksOn wo7 = new WorksOn(e2, p3, 17);
			WorksOn wo8 = new WorksOn(e2, p4, 20);
			WorksOn wo9 = new WorksOn(e2, p5, 30);

			session.save(wo1);
			session.save(wo2);
			session.save(wo3);
			session.save(wo4);
			session.save(wo5);
			session.save(wo6);
			session.save(wo7);
			session.save(wo8);
			session.save(wo9);

			tx.commit();
			
			System.out.println("Successfully added all the date.");
			session.close();
			factory.close();
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);

		}
	}

}
