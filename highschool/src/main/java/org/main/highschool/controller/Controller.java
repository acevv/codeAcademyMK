package org.main.highschool.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	static SessionFactory factory;

	public final List<Student> students = new ArrayList<>();

	public List<Student> getStudents() {
		return students;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public final List<Profesor> profesori = new ArrayList<>();

	public void inputProfesorDb() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(org.main.highschool.entity.Profesor.class);
		cfg.configure();

		Transaction tx = null;
		factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();

		for (Profesor profesor : profesori) {
			Profesor p = new Profesor();
			p.setName(profesor.getName());
			p.setEmail(profesor.getEmail());
			p.setSubject(profesor.getSubject());
			Subject s = new Subject();
			s.setPredmet(SubjectNames.Makedonski);
			s.setSubjectId(null);

			tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}

		factory.close();
		session.close();
		System.out.println("Success!");

	}

	public void inputSubjectDb() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(org.main.highschool.entity.Subject.class);
		cfg.configure();

		Transaction tx = null;
		factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();

		Student s = students.get(0);
		for (int i = 0; i < s.getSubjects().size(); i++) {
			Subject sub = new Subject();
			sub.setPredmet(s.getSubjects().get(i).getPredmet());
			// TO-DO: finish
		}

		factory.close();
		session.close();
		System.out.println("Success!");
	}

	public List<Student> readStudent(String csvPath) {

		Profesor pMate = new Profesor("Goce", SubjectNames.Matematika, "goce@email.com");
		Profesor pMake = new Profesor("Mile", SubjectNames.Makedonski, "mile@email.com");
		Profesor pFizi = new Profesor("Pero", SubjectNames.Fizika, "pero@email.com");
		Profesor pIsto = new Profesor("Laze", SubjectNames.Istorija, "laze@email.com");

		profesori.add(pMate);
		profesori.add(pMake);
		profesori.add(pIsto);
		profesori.add(pFizi);
		try (BufferedReader reads = new BufferedReader(new FileReader(csvPath));) {

			List<String> lines = new ArrayList<>();
			String line;
			Integer y = 0;

			while ((line = reads.readLine()) != null) {

				lines.add(line);
				y++;

			}

			for (int i = 0; i < lines.size(); i++) {

				List<Subject> predmet = new ArrayList<>();

				String sub[];
				Integer ocenka;

				String row[] = lines.get(i).split(";");

				Integer index = Integer.parseInt(row[0]);

				for (int j = 0; j < 4; j++) {

					sub = row[j + 6].split(",");
					ocenka = Integer.parseInt(sub[1]);
					Subject subject = new Subject(SubjectNames.valueOf(sub[0]), j, j); // PROBLEM !
					predmet.add(subject);

				}

				Student x = new Student(index, row[1], row[2], City.valueOf(row[5]), predmet);

				students.add(x);

			}

		} catch (IOException e) {
			System.err.println("Failed reading CSV file");
		}
		return students;
	}

}
