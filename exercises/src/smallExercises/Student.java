package smallExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

	private String name;
	private Integer score;

	public Student(String name, Integer score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public static List<String> studentsThatPass(Stream<Student> students, Integer score) {

		return students.filter(student -> student.getScore() > score)
				.sorted(Comparator.comparingInt(Student::getScore).reversed()).map(st -> st.name)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Ogi", 87));
		students.add(new Student("Mile", 57));
		students.add(new Student("Goce", 21));
		students.add(new Student("Trajce", 51));
		students.add(new Student("Petre", 67));
		students.add(new Student("Kole", 60));

		studentsThatPass(students.stream(), 50).forEach(System.out::println);

	}

}
