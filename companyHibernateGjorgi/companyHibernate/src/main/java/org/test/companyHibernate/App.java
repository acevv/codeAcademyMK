package org.test.companyHibernate;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.test.companyHibernate.entity.Department;
import org.test.companyHibernate.entity.Dependent;
import org.test.companyHibernate.entity.DependentEmbd;
import org.test.companyHibernate.entity.DLocationEmbd;
import org.test.companyHibernate.entity.WorksOnEmbd;
import org.xml.sax.SAXException;
import org.test.companyHibernate.entity.Employee;
import org.test.companyHibernate.entity.Project;
import org.test.companyHibernate.entity.WorksOn;
import org.test.companyHibernate.entity.DLocation;

public class App {

	public static final int numOfEmployees = 20;
	public static final int numOfDepartments = MockData.deptNames.length;
	public static final int numOfLocations = MockData.locations.length;
	public static final int numOfProjects = 10;
	public static int projectStartNum = 0;

	public static SessionFactory factory;

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		Transaction tx = null;

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.Employee.class);
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.Department.class);
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.DLocation.class);
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.Project.class);
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.WorksOn.class);
			cfg.addAnnotatedClass(org.test.companyHibernate.entity.Dependent.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			tx = session.beginTransaction();

//			loadMockData(session);

//			getAllEmployeesByProject(session);

//			findEmployeesByDno(session, (short) 1);
//			findEmployeesByDno(session, (short) 3);

//			getAllEmployeesByDepartment(session);

			tx.commit();
			session.close();
			factory.close();
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	private static void getAllEmployeesByDepartment(Session session) {

		List<Employee> allEmployees = session.createNativeQuery("SELECT * FROM public.employee;", Employee.class)
				.list();

		Set<Department> departments = new HashSet<>();
		allEmployees.forEach(empl -> departments.add(empl.getDno()));

		Map<Department, List<Employee>> employeesByDepartment = new HashMap<>();

		// populating the hashmap with employees
		for (Department department : departments) {
			List<Employee> employees = new ArrayList<>();
			for (Employee employee : allEmployees) {
				if (department.getDnumber() == employee.getDno().getDnumber()) {
					employees.add(employee);
				}
			}
			employeesByDepartment.put(department, employees);
		}

		// printing employees by department
		for (Department department : departments) {
			System.out.println("In department " + department.getDname() + " (dep no. " + department.getDnumber()
					+ ") are working:");
			employeesByDepartment.get(department)
					.forEach(empl -> System.out.println(empl.getSsn() + " " + empl.getFname() + " " + empl.getLname()));
		}

	}

	private static void findEmployeesByDno(Session session, short dno) {
		List<Employee> employees = session.createQuery("SELECT e FROM Employee AS e WHERE e.dno=" + dno).list();

		System.out.println("In " + employees.get(0).getDno().getDname() + " deprtment are working:");
		employees.forEach(empl -> System.out.println(empl.getSsn() + " " + empl.getFname() + " " + empl.getLname()));

	}

	private static void getAllEmployeesByProject(Session session) {

		String hqlWorksOn = "SELECT w FROM WorksOn w";
		Query queryWorksOn = session.createQuery(hqlWorksOn);
		List<WorksOn> worksOn = queryWorksOn.list();

		Set<Project> projects = new HashSet<>();
		worksOn.forEach(w -> projects.add(w.getEmployeeProject().getProject()));

		Map<Project, List<Employee>> employeesByProject = new HashMap<>();

		// populating hashmap with employees
		for (Project project : projects) {
			List<Employee> employees = new ArrayList<>();
			for (WorksOn w : worksOn) {
				if (project.getPnumber() == w.getEmployeeProject().getProject().getPnumber()) {
					employees.add(w.getEmployeeProject().getEmployee());
				}
			}
			employeesByProject.put(project, employees);
		}

		// printing all employees by project
		for (Project project : projects) {
			System.out.println("PNumber " + project.getPnumber() + ", " + project.getPname() + ": ");
			employeesByProject.get(project)
					.forEach(empl -> System.out.println(empl.getSsn() + " " + empl.getFname() + " " + empl.getLname()));
		}

	}

	private static void loadMockData(Session session) throws ParserConfigurationException, SAXException, IOException {

		// initialize departments and set minimum data
		List<Department> departments = new ArrayList<>();
		for (int i = 0; i < numOfDepartments; i++) {
			Department dpt = new Department();
			dpt.setDname(MockData.deptNames[i]);
			departments.add(dpt);
		}

		for (Department dep : departments) {
			session.save(dep);
		}
//		departments.forEach(dep -> session.save(dep));

		// set employees data
		List<String> maleNames = MockData.readNames("src/main/resources/males.xml", "firstName");
		List<String> femaleNames = MockData.readNames("src/main/resources/females.xml", "firstName");
		List<String> lastNames = MockData.readNames("src/main/resources/lastnames.xml", "lastName");
		List<String> addresses = MockData.readAddresses("src/main/resources/MOCK_ADDRESS.txt");
		Set<Long> ssns = MockData.generateSsns(numOfEmployees);
		List<Employee> employees = new ArrayList<>();

		int i = 0;
		for (Long ssn : ssns) {
			Employee empl = new Employee();
			empl.setAddress(addresses.get(i));
			empl.setBdate(MockData.randDateBetween(MockData.adultBStartDate, MockData.adultBEndDate));
			empl.setMinit(MockData.getRandChar());
			empl.setSsn(ssn);
			empl.setSalary(MockData.randomSalary());
			empl.setLname(lastNames.get(i));

			char gender = MockData.maleOrFemale();
			empl.setSex(gender);
			if (gender == 'M')
				empl.setFname(maleNames.get(i));
			if (gender == 'F')
				empl.setFname(femaleNames.get(i));

			// set department and superssns
			if (i < 5) {
				empl.setDno(departments.get(0));
				if (i != 0)
					empl.setSuperssn(employees.get(0));
			}
			if (i >= 5 && i < 10) {
				empl.setDno(departments.get(1));
				if (i != 5)
					empl.setSuperssn(employees.get(5));
			}
			if (i >= 10 && i < 15) {
				empl.setDno(departments.get(2));
				if (i != 10)
					empl.setSuperssn(employees.get(10));
			}
			if (i >= 15) {
				empl.setDno(departments.get(3));
				if (i != 15)
					empl.setSuperssn(employees.get(15));
			}

			session.save(empl);
			employees.add(empl);
			i++;

		}

		// completing department data
		List<DLocation> dptLocations = new ArrayList<>();

		for (int j = 0; j < numOfDepartments; j++) {
			Department dpt = departments.get(j);
			dpt.setMgrStartDate(MockData.randDateBetween(MockData.mgrStartDate, MockData.mgrEndDate));
			dpt.setMgrssn(employees.get(j * 5));

			// set dept_location data
			if (j == 0 || j == 2) {
				for (int k = 0; k < numOfLocations; k++) {
					DLocationEmbd dLocEmbd = new DLocationEmbd();
					dLocEmbd.setDlocation(MockData.locations[k]);
					dLocEmbd.setDepartment(dpt);

					DLocation dLocation = new DLocation();
					dLocation.setDeptLocPkey(dLocEmbd);

					dptLocations.add(dLocation);
					session.save(dLocation);
				}
			} else {
				DLocationEmbd dLocEmbd = new DLocationEmbd();
				dLocEmbd.setDlocation(MockData.locations[0]);
				dLocEmbd.setDepartment(dpt);

				DLocation dLocation = new DLocation();
				dLocation.setDeptLocPkey(dLocEmbd);

				dptLocations.add(dLocation);
				session.save(dLocation);
			}

		}

		// setting up project data
		Set<String> projectNames = new HashSet<>();
		MockData.randProjectsNames(numOfProjects, projectNames);

		Set<Project> projectsSet = new HashSet<>();
		int pCount = 0;
		for (String pName : projectNames) {
			Project project = new Project();
			project.setPname(pName);
			project.setPnumber(projectStartNum += 100);
			project.setDLocation(dptLocations.get(pCount % dptLocations.size()));

			projectsSet.add(project);
			session.save(project);
			pCount++;
		}

		// setting up works_on
		List<Project> projectsList = new ArrayList<>();
		projectsList.addAll(projectsSet);

		int worksOnCount = 0;
		for (Employee employee : employees) {
			for (int r = 0; r < 4; r++) {
				WorksOnEmbd worksEmbd = new WorksOnEmbd();
				worksEmbd.setEmployee(employee);
				worksEmbd.setProject(projectsList.get(worksOnCount % numOfProjects));

				WorksOn worksOn = new WorksOn();
				worksOn.setEmployeeProject(worksEmbd);
				worksOn.setHours(10);

				session.save(worksOn);
				worksOnCount++;
			}
		}

		// setting up dependents
		for (Employee employee : employees) {
			Double randNum = Math.random();

			// if daughter
			if (randNum > 0.8) {
				DependentEmbd dependentEmbd = new DependentEmbd();
				dependentEmbd.setEssn(employee);
				dependentEmbd.setDependentName(femaleNames.get((int) Math.floor(Math.random() * femaleNames.size())));

				Dependent dependent = new Dependent();
				dependent.setEssnDependent(dependentEmbd);
				dependent.setSex('F');
				dependent.setRelationship("Daughter");
				dependent.setBdate(new Date((long) (employee.getBdate().getTime() + 27 * MockData.oneYear)));

				session.save(dependent);
			}

			if (randNum <= 0.8 && randNum > 0.6) {
				DependentEmbd dependentEmbd = new DependentEmbd();
				dependentEmbd.setEssn(employee);
				dependentEmbd.setDependentName(maleNames.get((int) Math.floor(Math.random() * maleNames.size())));

				Dependent dependent = new Dependent();
				dependent.setEssnDependent(dependentEmbd);
				dependent.setSex('M');
				dependent.setRelationship("Son");
				dependent.setBdate(new Date((long) (employee.getBdate().getTime() + 27 * MockData.oneYear)));

				session.save(dependent);
			}

			if (randNum <= 0.6 && randNum > 0.4) {
				DependentEmbd dependentEmbd = new DependentEmbd();
				dependentEmbd.setEssn(employee);
				Dependent dependent = new Dependent();

				if (employee.getSex() == 'F') {
					dependentEmbd.setDependentName(maleNames.get((int) Math.floor(Math.random() * maleNames.size())));
					dependent.setSex('M');
				} else {
					dependentEmbd
							.setDependentName(femaleNames.get((int) Math.floor(Math.random() * femaleNames.size())));
					dependent.setSex('F');
				}

				dependent.setEssnDependent(dependentEmbd);
				dependent.setRelationship("Spouse");
				dependent.setBdate(MockData.randDateBetween(MockData.adultBStartDate, MockData.adultBEndDate));

				session.save(dependent);
			}

		}

	}

}
