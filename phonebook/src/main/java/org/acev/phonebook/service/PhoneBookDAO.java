package org.acev.phonebook.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.acev.phonebook.entity.Address;
import org.acev.phonebook.entity.CityAreaCode;
import org.acev.phonebook.entity.ContactInfo;
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

public class PhonebookDAO {

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

	public static void createContact(ContactInfo contact) {

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			Person p = new Person();
			p.setFirstName(contact.getfName());
			p.setLastName(contact.getlName());
			p.setEmbg(contact.getEmbg());

			s.save(p);
			tx.commit();
			tx = s.beginTransaction();

			Address ad = new Address();
			ad.setPerson(p);
			ad.setCity(contact.getCity());
			ad.setStreet(contact.getStreet());
			ad.setStreetNumber(contact.getStreetNumber());

			s.save(ad);
			tx.commit();
			tx = s.beginTransaction();

			CityAreaCode cityCode = setCityAreaCode(contact.getPhoneNumber());

			s.save(cityCode);
			tx.commit();
			tx = s.beginTransaction();

			CountryCode countryCode = setCountryCode(contact.getPhoneNumber());

			s.save(countryCode);
			tx.commit();
			tx = s.beginTransaction();

			PhoneBook phoneBook = new PhoneBook();
			phoneBook.setPhoneNumber(contact.getPhoneNumber());
			phoneBook.setPerson(p);
			phoneBook.setCityAreaCode(cityCode);
			phoneBook.setCountryCode(countryCode);

			s.save(phoneBook);
			tx.commit();

			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	private static CountryCode setCountryCode(String phoneNumber) {
		String code = phoneNumber.substring(1, 4);
		CountryCode countryCode = new CountryCode();

		// ova definitivno ne e dobar nacin bidejki ke raboti samo za MK
		if (code.contains("389")) {
			countryCode.setCountryCode(code);
			countryCode.setCountryName("Macedonia");
		}

		return countryCode;
	}

	private static CityAreaCode setCityAreaCode(String phoneNumber) {

		String areaCode = phoneNumber.substring(4, 5);
		String localCode = phoneNumber.substring(4, 6);

		CityAreaCode cityArea = new CityAreaCode();

		if (areaCode.contains("2")) {
			cityArea.setCityAreaCode(phoneNumber.substring(4, 5));
			cityArea.setCityLocalAreaCode(null);
			cityArea.setCityName("Skopje");
		} else if (areaCode.contains("3")) {

			switch (localCode) {
			case "31":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Kumanovo");
				break;
			case "32":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Shtip");
				break;
			case "33":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Kochani");
				break;
			case "34":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Strumica");
				break;

			default:
				cityArea.setCityAreaCode(null);
				cityArea.setCityLocalAreaCode(null);
				cityArea.setCityName(null);
				break;
			}
		} else if (areaCode.contains("4")) {

			switch (localCode) {
			case "42":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Gostivar");
				break;
			case "43":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Veles");
				break;
			case "44":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Tetovo");
				break;
			case "45":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Kichevo");
				break;
			case "46":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Ohrid");
				break;
			case "47":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Bitola");
				break;
			case "48":
				cityArea.setCityAreaCode(areaCode);
				cityArea.setCityLocalAreaCode(localCode);
				cityArea.setCityName("Prilep");
				break;

			default:
				cityArea.setCityAreaCode(null);
				cityArea.setCityLocalAreaCode(null);
				cityArea.setCityName(null);
				break;
			}
		}

		return cityArea;

	}

	public static void updateContact(Long embg, ContactInfo contact) {

		try {

			PhoneBook pb = getPhoneBookByEmbg(embg);
			Person p = pb.getPerson();
			Address ad = findAddressByEmbg(embg);
			CityAreaCode cityCode = pb.getCityAreaCode();
			Integer cityCodeId = cityCode.getId();
			CountryCode countryCode = pb.getCountryCode();
			Integer countryCodeId = cityCode.getId();

			Session s = initDB();
			tx = s.beginTransaction();

			if (contact.getCity() != null) {
				ad.setCity(contact.getCity());
			}

			if (contact.getStreet() != null) {
				ad.setStreet(contact.getStreet());
			}

			if (contact.getStreetNumber() != null) {
				ad.setStreetNumber(contact.getStreetNumber());
			}

			if (contact.getfName() != null) {
				p.setFirstName(contact.getfName());
			}

			if (contact.getlName() != null) {
				p.setLastName(contact.getlName());
			}

			if (contact.getPhoneNumber() != null) {
				s.delete(pb);
				tx.commit();
				tx = s.beginTransaction();
				cityCode = setCityAreaCode(contact.getPhoneNumber());
				cityCode.setId(cityCodeId);
				countryCode = setCountryCode(contact.getPhoneNumber());
				countryCode.setId(countryCodeId);

				pb.setPerson(p);
				s.update(cityCode);
				s.update(countryCode);
				pb.setCityAreaCode(cityCode);
				pb.setCountryCode(countryCode);
				pb.setPhoneNumber(contact.getPhoneNumber());
				s.save(pb);

			}

			s.update(p);
			s.update(ad);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	private static PhoneBook getPhoneBookByEmbg(Long embg) {
		List<PhoneBook> result = new ArrayList<PhoneBook>();

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM PhoneBook AS p WHERE p.person='" + embg + "'").list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result.get(0);

	}

	@SuppressWarnings("unchecked")
	private static Address findAddressByEmbg(Long embg) {
		List<Address> result = new ArrayList<Address>();

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM Address AS p WHERE p.person='" + embg + "'").list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	public static List<PhoneBook> getAllFromDB() {

		List<PhoneBook> result = new ArrayList<PhoneBook>();

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM PhoneBook AS p").list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static PhoneBook getByPhoneNumber(String phone) {
		List<PhoneBook> result = new ArrayList<PhoneBook>();
		String phone2 = "+" + phone;
		try {
			Session s = initDB();
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM PhoneBook AS p WHERE p.phoneNumber='" + phone2 + "'").list();

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result.get(0);
	}

	public static List<PhoneBook> getAllByFirstName(String fName) {

		List<PhoneBook> all = PhonebookDAO.getAllFromDB();
		List<PhoneBook> result = new ArrayList<PhoneBook>();
		for (PhoneBook contact : all) {
			if (contact.getPerson().getFirstName().equals(fName)) {
				result.add(contact);
			}
		}
		return result;
	}

	public static List<PhoneBook> getContactByCountryCode(String code) {
		List<PhoneBook> all = PhonebookDAO.getAllFromDB();
		List<PhoneBook> result = new ArrayList<PhoneBook>();
		for (PhoneBook contact : all) {
			if (contact.getCountryCode().getCountryCode().equals(code)) {
				result.add(contact);
			}
		}

		return result;
	}

	public static List<PhoneBook> getByCityCode(String code) {
		List<PhoneBook> all = PhonebookDAO.getAllFromDB();
		List<PhoneBook> result = new ArrayList<PhoneBook>();
		for (PhoneBook contact : all) {
			if (contact.getCityAreaCode().getCityLocalAreaCode().equals(code)) {
				result.add(contact);
			}
		}

		return result;
	}

	public static List<PhoneBook> getAllByPerson(Person person) {
		List<PhoneBook> all = PhonebookDAO.getAllFromDB();
		List<PhoneBook> result = new ArrayList<PhoneBook>();
		for (PhoneBook contact : all) {
			if (contact.getPerson().getEmbg().equals(person.getEmbg())) {
				result.add(contact);
			}
		}

		return result;
	}
	

	public static void deleteContact(Long embg) {

		try {
			Session s = initDB();

			PhoneBook pb = getPhoneBookByEmbg(embg);
			Person p = pb.getPerson();
			Address ad = findAddressByEmbg(embg);
			CityAreaCode cityCode = pb.getCityAreaCode();
			CountryCode countryCode = pb.getCountryCode();

			tx = s.beginTransaction();
			s.delete(pb);
			s.delete(countryCode);
			s.delete(cityCode);
			s.delete(ad);
			s.delete(p);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
