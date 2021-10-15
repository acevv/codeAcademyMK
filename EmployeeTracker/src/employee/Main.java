package employee;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();

		Employee e1 = new Employee();
		e1.setFirstName("Mite");
		e1.setLastName("Trajkov");
		e1.showStats();

		Employee e2 = new Employee("Vaso", "Angelov", "Tesar", "Oraovica");
		e2.showStats();
		
		employees.add(e2);
		System.out.println(employees.toString());

	}

}
