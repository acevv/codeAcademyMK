import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestResults {
	public static class Student {
		private String name;
		private int score;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public String getName() {
			return name;
		}
	}

	public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {

//		students.filter(student -> student.getScore() > passingScore).sorted(Comparator.comparingInt(null))
//students.map(null)
		return students.filter(student -> student.getScore() > passingScore).sorted().map(ele -> ele.name)
				.collect(Collectors.toList());

	}

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Mike", 80));
		students.add(new Student("James", 57));
		students.add(new Student("Alan", 21));

		studentsThatPass(students.stream(), 50).forEach(System.out::println);
	}
}