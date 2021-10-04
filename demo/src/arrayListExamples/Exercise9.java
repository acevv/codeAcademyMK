package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise9 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");

		System.out.println("Array 1 is: " + colors);

		ArrayList<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
		numbers.add("5");

		System.out.println("Array 2 is: " + numbers);

		Collections.copy(colors, numbers);
		System.out.println("Numbers Copy to Colors, \nAfter Copy: ");
		System.out.println("Array 1 is: " + colors);
		System.out.println("Array 2 is: " + numbers);

	}

}
