package org.main.highschool.controller;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.highschool.City;
import org.main.highschool.SubjectNames;
import org.main.highschool.entity.Profesor;
import org.main.highschool.entity.Student;
import org.main.highschool.entity.Subject;

public class Controller {

	public static List<Student> students = new ArrayList<>();
	public static List<Profesor> profesors = new ArrayList<>();
	public static List<Subject> subjects = new ArrayList<>();
	public static SessionFactory factory;

	public void openSession() {

		String pathProfesor = "/Users/acev/eclipse-workspace/codeAcademy/codeAcademyMK/highschool/src/main/resources/profesor.txt";
		String pathStudent = "/Users/acev/eclipse-workspace/codeAcademy/codeAcademyMK/highschool/src/main/resources/data.txt";
		String pathSubject = "/Users/acev/eclipse-workspace/codeAcademy/codeAcademyMK/highschool/src/main/resources/subject.txt";

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.main.highschool.entity.Profesor.class);
			cfg.addAnnotatedClass(org.main.highschool.entity.Subject.class);
			cfg.addAnnotatedClass(org.main.highschool.entity.Student.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			readWriteProfesor(pathProfesor, session);

			readStudent(pathStudent);
			readWriteSubject(pathSubject, session);
			writeStudent(session);

			session.close();
			factory.close();
		} catch (Exception e) {

		}

	}

	private void writeStudent(Session session) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (Student student : students) {
				
				student.setSubjects(subjects);
				session.save(student);

			}
			tx.commit();

		} catch (HibernateException e2) {
			tx.rollback();
			System.out.println(e2);

		}

	}

	private void readWriteSubject(String path, Session session) {
		Transaction tx = null;

		try (BufferedReader reads = new BufferedReader(new FileReader(path));) {

			List<String> lines = new ArrayList<>();
			String line;

			while ((line = reads.readLine()) != null) {
				lines.add(line);
			}

			String row[] = lines.get(0).split(";");

			tx = session.beginTransaction();

			Subject s = new Subject();
			s.setPredmet(row[2]);
			List<Profesor> profs = new ArrayList<>();
			for (Profesor profesor : profesors) {

				if (profesor.getSubject().equals(row[2])) {
					profs.add(profesor);
				}
			}
			s.setProfesor(profs);
			subjects.add(s);

			session.save(s);

			Subject s2 = new Subject();
			List<Profesor> profs2 = new ArrayList<>();
			s2.setPredmet(row[5]);
			for (Profesor profesor : profesors) {
				if (profesor.getSubject().equals(row[5])) {
					profs2.add(profesor);
				}
			}
			s2.setProfesor(profs2);
			subjects.add(s2);
			session.save(s2);

			Subject s3 = new Subject();
			List<Profesor> profs3 = new ArrayList<>();
			s3.setPredmet(row[8]);
			for (Profesor profesor : profesors) {
				if (profesor.getSubject().equals(row[8])) {
					profs3.add(profesor);
				}
			}
			s3.setProfesor(profs3);
			subjects.add(s3);
			session.save(s3);

			Subject s4 = new Subject();
			List<Profesor> profs4 = new ArrayList<>();
			s4.setPredmet(row[11]);
			for (Profesor profesor : profesors) {
				if (profesor.getSubject().equals(row[11])) {
					profs4.add(profesor);
				}
			}
			s4.setProfesor(profs4);
			subjects.add(s4);
			session.save(s4);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void readStudent(String path) {

		try (BufferedReader reads = new BufferedReader(new FileReader(path));) {
			List<String> lines = new ArrayList<>();
			String line;

			while ((line = reads.readLine()) != null) {
				lines.add(line);
			}

			for (int i = 0; i < lines.size(); i++) {
				String row[] = lines.get(i).split(";");

				Student s = new Student();
				s.setIndex(Integer.parseInt(row[0]));
				s.setName(row[1]);
				s.setSurname(row[2]);
				s.setEmail(row[3]);
				String grad = City.valueOf(row[4]).toString();
				s.setCity(grad);

				students.add(s);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void readWriteProfesor(String path, Session session) {
		Transaction tx = null;

		try (BufferedReader reads = new BufferedReader(new FileReader(path));) {

			List<String> lines = new ArrayList<>();
			String line;

			while ((line = reads.readLine()) != null) {
				lines.add(line);
			}

			for (int i = 0; i < lines.size(); i++) {
				String row[] = lines.get(i).split(";");

				tx = session.beginTransaction();
				String subject = SubjectNames.valueOf(row[2]).toString();

				Profesor p = new Profesor(Integer.parseInt(row[0]), row[1], subject, row[3]);
				profesors.add(p);
				session.save(p);
				tx.commit();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public List<Profesor> getProfesori() {
//		return profesori;
//	}
//
//	public final List<Profesor> profesori = new ArrayList<>();
//
//	public void inputProfesorDb() {
//
//		Configuration cfg = new Configuration();
//		cfg.addAnnotatedClass(org.main.highschool.entity.Profesor.class);
//		cfg.configure();
//
//		Transaction tx = null;
//		factory = cfg.configure().buildSessionFactory();
//		Session session = factory.openSession();
//
//		for (Profesor profesor : profesori) {
//			Profesor p = new Profesor();
//			p.setName(profesor.getName());
//			p.setEmail(profesor.getEmail());
//			p.setSubject(profesor.getSubject());
//			Subject s = new Subject();
//			s.setPredmet(SubjectNames.Makedonski);
//			s.setSubjectId(null);
//
//			tx = session.beginTransaction();
//			session.save(p);
//			tx.commit();
//		}
//
//		factory.close();
//		session.close();
//		System.out.println("Success!");
//
//	}
//
//	public void inputSubjectDb() {
//		Configuration cfg = new Configuration();
//		cfg.addAnnotatedClass(org.main.highschool.entity.Subject.class);
//		cfg.configure();
//
//		Transaction tx = null;
//		factory = cfg.configure().buildSessionFactory();
//		Session session = factory.openSession();
//
//		Student s = students.get(0);
//		for (int i = 0; i < s.getSubjects().size(); i++) {
//			Subject sub = new Subject();
//			sub.setPredmet(s.getSubjects().get(i).getPredmet());
//			// TO-DO: finish
//		}
//
//		factory.close();
//		session.close();
//		System.out.println("Success!");
//	}
//
//	public List<Student> readStudent(String csvPath) {
//
//		Profesor pMate = new Profesor("Goce", SubjectNames.Matematika, "goce@email.com");
//		Profesor pMake = new Profesor("Mile", SubjectNames.Makedonski, "mile@email.com");
//		Profesor pFizi = new Profesor("Pero", SubjectNames.Fizika, "pero@email.com");
//		Profesor pIsto = new Profesor("Laze", SubjectNames.Istorija, "laze@email.com");
//
//		profesori.add(pMate);
//		profesori.add(pMake);
//		profesori.add(pIsto);
//		profesori.add(pFizi);
//		try (BufferedReader reads = new BufferedReader(new FileReader(csvPath));) {
//
//			List<String> lines = new ArrayList<>();
//			String line;
//			Integer y = 0;
//
//			while ((line = reads.readLine()) != null) {
//
//				lines.add(line);
//				y++;
//
//			}
//
//			for (int i = 0; i < lines.size(); i++) {
//
//				List<Subject> predmet = new ArrayList<>();
//
//				String sub[];
//				Integer ocenka;
//
//				String row[] = lines.get(i).split(";");
//
//				Integer index = Integer.parseInt(row[0]);
//
//				for (int j = 0; j < 4; j++) {
//
//					sub = row[j + 6].split(",");
//					ocenka = Integer.parseInt(sub[1]);
//					Subject subject = new Subject(SubjectNames.valueOf(sub[0]), j, j); // PROBLEM !
//					predmet.add(subject);
//
//				}
//
//				Student x = new Student(index, row[1], row[2], City.valueOf(row[5]), predmet);
//
//				students.add(x);
//
//			}
//
//		} catch (IOException e) {
//			System.err.println("Failed reading CSV file");
//		}
//		return students;
//	}

}
