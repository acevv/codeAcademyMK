package org.main.studentDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	public final List<Student> students = new ArrayList<>();

	public void printStudents() {

		for (Student student : students) {

			System.out.println(student);

		}

	}

	public List<Student> readStudent(String csvPath) {

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
				List<Profesor> profesori = new ArrayList<>();
				String sub[];
				Integer ocenka;

				String row[] = lines.get(i).split(";");

				Integer index = Integer.parseInt(row[0]);

				Profesor pMate = new Profesor("Goce", SubjectNames.Matematika, "goce@email.com");
				Profesor pMake = new Profesor("Mile", SubjectNames.Makedonski, "mile@email.com");
				Profesor pFizi = new Profesor("Pero", SubjectNames.Fizika, "pero@email.com");
				Profesor pIsto = new Profesor("Laze", SubjectNames.Istorija, "laze@email.com");

				profesori.add(pMate);
				profesori.add(pMake);
				profesori.add(pIsto);
				profesori.add(pFizi);

				for (int j = 0; j < 4; j++) {

					sub = row[j + 6].split(",");
					ocenka = Integer.parseInt(sub[1]);
					Subject subject = new Subject(SubjectNames.valueOf(sub[0]), ocenka, profesori.get(j));
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

	@Override
	public void createStudentTable() {
		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.student (" + "index INTEGER NOT NULL," + "name VARCHAR(20),"
					+ "surname VARCHAR(20)," + "city VARCHAR(20)," + "PRIMARY KEY(index)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				System.out.println("Succsessfully created table.");
			} else {
				System.out.println("Failed to create table.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public String createProfesorTable() {
		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.profesor (" + "prof_id SERIAL," + "name VARCHAR(20),"
					+ "email VARCHAR(30)," + "PRIMARY KEY(prof_id)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				System.out.println("Succsessfully created table.");
			} else {
				System.out.println("Failed to create table.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String createSubjectTabe() {
		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.subject (" + "subject_id SERIAL," + "name VARCHAR(20),"
					+ "prof_id INTEGER," + "PRIMARY KEY(subject_id),"
					+ "FOREIGN KEY(prof_id) REFERENCES public.profesor(prof_id)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				System.out.println("Succsessfully created table.");
			} else {
				System.out.println("Failed to create table.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void insertStudents(List<Student> students) {
		Connection conn = JDBCConfig.getConnection();

		try {
			String query = "INSERT INTO public.student(" + "	index, name, surname, city)"
					+ "	VALUES (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			for (Student student : students) {
				ps.setInt(1, student.getIndex());
				ps.setString(2, student.getName());
				ps.setString(3, student.getSurname());
				ps.setString(4, student.getCity().toString());
				ps.execute();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void insertSubject(List<Student> students) {

		Connection conn = JDBCConfig.getConnection();

		Student s = new Student();
		s = students.get(0);

		try {
			String query = "INSERT INTO public.subject(\n" + " name, prof_id)\n" + "	VALUES (?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);

			for (int i = 0; i < s.getSubject().size(); i++) {
				ps.setString(1, s.getSubject().get(i).getPredmet().toString());
				ps.setInt(2, i + 1);
				ps.execute();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override

	public void insertProfesor(List<Student> students) {
		Connection conn = JDBCConfig.getConnection();

		Student s = new Student();
		s = students.get(0);
		try {
			String query = "INSERT INTO public.profesor(" + "	name, email)" + "	VALUES (?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);

			for (int i = 0; i < s.getSubject().size(); i++) {
				ps.setString(1, s.getSubject().get(i).getProfesor().getName());
				ps.setString(2, s.getSubject().get(i).getProfesor().getEmail());
				ps.execute();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override

	public void createStudentSubjectTable() {
		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.student_subject (" + "index INTEGER," + "subject_id INTEGER,"
					+ "ocenka INTEGER," + "FOREIGN KEY(index) REFERENCES public.student(index),"
					+ "FOREIGN KEY(subject_id) REFERENCES public.subject(subject_id)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				System.out.println("Succsessfully created table.");
			} else {
				System.out.println("Failed to create table.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void insertOcenka(List<Student> students) {
		Connection conn = JDBCConfig.getConnection();

		try {
			String query = "INSERT INTO public.student_subject(\n" + "	index, subject_id, ocenka)\n"
					+ "	VALUES (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			for (Student student : students) {

				for (int i = 0; i < student.getSubject().size(); i++) {
					ps.setInt(1, student.getIndex());
					ps.setInt(2, i + 1);
					ps.setInt(3, student.getSubject().get(i).getOcenka());
					ps.execute();
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void searchPolozenPoPredmet(SubjectNames s, Integer ocenka) {
		Connection conn = JDBCConfig.getConnection();
		Integer subjectId = 0;

		switch (s) {
		case Makedonski:
			subjectId = 2;
			break;
		case Matematika:
			subjectId = 1;
			break;
		case Fizika:
			subjectId = 4;
			break;
		case Istorija:
			subjectId = 3;
			break;
		default:
			subjectId = 0;
			break;
		}

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.student JOIN public.student_subject"
					+ " ON public.student.index = public.student_subject.index " + "WHERE subject_id =" + subjectId
					+ " AND ocenka > " + ocenka + ";";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Integer index = rs.getInt("index");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String city = rs.getString("city");
				Integer ocena = rs.getInt("ocenka");
				System.out.println("Index: " + index + ", Name: " + name + ", Surname: " + surname + ", ciry: " + city
						+ ", Subject: " + s.toString() + ", ocena: " + ocena);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void searchProfesor(Integer index, SubjectNames s) {

		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM student_subject JOIN subject "
					+ "ON student_subject.subject_id = subject.subject_id "
					+ "JOIN profesor ON subject.prof_id = profesor.prof_id " + "WHERE index =" + index
					+ " AND subject.name = '" + s.toString() + "';";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString(8);
				String email = rs.getString(9);
				System.out.println("Studentot: " + Name: " + name + ", email: " + email);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
