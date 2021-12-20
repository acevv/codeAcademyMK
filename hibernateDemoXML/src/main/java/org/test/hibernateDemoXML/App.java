package org.test.hibernateDemoXML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.test.hibernateDemoXML.entity.Employee;

public class App {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata m = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = m.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		// vidi video za employee 7:37
		Employee e1 = new Employee(1, "Dimitar", "Josifov", 18000);
		session.save(e1);
		
		t.commit();
		
		factory.close();
		session.close();
	}
}
