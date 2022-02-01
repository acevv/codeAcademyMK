package org.acev.phonebook.service;

import java.io.File;

import org.acev.phonebook.entity.Address;
import org.acev.phonebook.entity.CityAreaCode;
import org.acev.phonebook.entity.CountryCode;
import org.acev.phonebook.entity.Person;
import org.acev.phonebook.entity.PhoneBook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	public static void main(String[] args) {
		initDB();
	}
	
	static Transaction tx = null;

	public static Session initDB() {

		String hibernateCFGFilePath = "/Users/acev/eclipse-workspace/codeAcademy/codeAcademyMK/phonebook/src/main/resources/hibernate.cfg.xml";
		File hibernateCFG = new File(hibernateCFGFilePath);

		try {

			Configuration cfg = new Configuration();

			cfg.configure(hibernateCFG);
			cfg.addAnnotatedClass(Person.class);
			cfg.addAnnotatedClass(Address.class);
			cfg.addAnnotatedClass(CityAreaCode.class);
			cfg.addAnnotatedClass(CountryCode.class);
			cfg.addAnnotatedClass(PhoneBook.class);

			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

			SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
			Session session = factory.openSession();

			return session;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
}
