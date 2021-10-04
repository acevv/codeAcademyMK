package arrayListExamples;

import java.util.ArrayList;

public class Exercise13 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");

		System.out.println("Colors   array: " + colors);

		ArrayList<String> colors2 = new ArrayList<>();
		colors2.add("Black");
		colors2.add("Green");
		colors2.add("Purple");
		colors2.add("White");
		colors2.add("Red");

		System.out.println("Colors 2 array: " + colors2);

		ArrayList<String> result = new ArrayList<>();

		for (String boja : colors) {
			System.out.println(boja);
			if (colors2.contains(boja)) {
				result.add("True");
			} else {
				result.add("False");
			}
		}

		System.out.println(result);

	}

}
