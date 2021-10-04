package arrayListExamples;

import java.util.ArrayList;

public class Exercise4 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();

		colors.add("Red");
		colors.add("White");
		colors.add("Orange");
		colors.add("BLue");
		colors.add("Yellow");
		System.out.println("Colors: " + colors);
		
		
		System.out.println("Element with index 1 is: " + colors.get(1));
	}

}
