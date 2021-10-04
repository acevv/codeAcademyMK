package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise8 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");
		System.out.println("Original array: " + colors);
		
		Collections.sort(colors);
		
		System.out.println("Sorted array: " + colors);
		
		// Sort descending ( reversed array)
		
		Collections.reverse(colors);
		System.out.println("Reversed array: " + colors);
		
	}

}
