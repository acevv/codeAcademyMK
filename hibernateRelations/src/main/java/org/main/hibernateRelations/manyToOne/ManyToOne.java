package org.main.hibernateRelations.manyToOne;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
//			session.save(p1);

			Department d1 = new Department("IoT", 10);
			d1.setProject(p1);
//			session.save(d1);

			Date date = new Date(System.currentTimeMillis());

			Employee e1 = new Employee("Ognen Ilioski", 9999, date);
			e1.setDepartment(d1);

			Employee e2 = new Employee("Vlatko Doncev", 9999, date);
			e1.setDepartment(d1);

//			session.save(e1);
//			session.save(e2);

//			findEmployeeData(2L, session);



			
// Find all employees working on the same project -1 COMPLETED!
			
			Long projectId = 21L;
			List<Employee> result = findEmployeesOnaSameProject(projectId, session);
			String pName = result.get(0).getDepartment().getProject().getDescription();

			System.out.print("Employees working on Project \"" + pName + "\" are: ");
			for (Employee employee : result) {
				System.out.print(employee.getName() + ", ");
			}
			System.out.println("");

// Find all employees working in predefined Department -2
			
			Long department = 21L;
			List<Employee> empByDept = findEmployeesInPredifnedDepartment(session, department);
			System.out.print("All employees working in department " + department + " are: ");
			for (Employee employee : empByDept) {
				System.out.print(employee.getName() + ", ");
			}
			System.out.println("");
			
// Find all employees working in same Department -3  COMPLETED

			

			
			
			
			
			
			
			tx.commit();
			factory.close();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	private static List<Employee> findEmployeesInPredifnedDepartment(Session session, Long department) {
		String hql = "SELECT e FROM Employee e JOIN e.department d WHERE d.id=:deptid";

		Query query = session.createQuery(hql);
		List<Employee> result = query.setParameter("deptid", department).list();

		return result;

	}

	private static List<Employee> findEmployeesOnaSameProject(Long projectId, Session session) {

		String hql = "SELECT e FROM Employee e JOIN e.department d JOIN d.project p WHERE d.id=:deptid and p.id=d.id";
		Query query = session.createQuery(hql);
		List<Employee> result = query.setParameter("deptid", projectId).list();
		return result;

	}

	private static void findEmployeeData(long l, Session session) {

		String hql = "SELECT e FROM Employee e WHERE e.id=:empid";
		Query query = session.createQuery(hql);

		List<Employee> res = query.setParameter("empid", l).list();

		System.out.println("Ime i prezime: " + res.get(0).getName());

		Department d = res.get(0).getDepartment();

		System.out.println("Dept name: " + d.getDeptName());

		Project p = d.getProject();

		System.out.println("Project name: " + p.getProjectName());

	}

}
