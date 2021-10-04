package arrayListExamples;

import java.util.ArrayList;

public class Exercise3 {

	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();
		colors.add("White");
		colors.add("Orange");
		colors.add("Black");
		colors.add("Red");
		colors.add("Yellow");
		
		System.out.println("First array: " + colors);
		colors.add(0, "Pink");
		
		System.out.println("Modified first array: " + colors);
	}

}
