package arrayListExamples;

import java.util.ArrayList;

public class Exercise5 {
	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();
		
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Black");
		
		System.out.println("Originalna niza: " + colors);
		
		colors.set(2, "Yellow");
		
		System.out.println("Modificirana niza: " + colors);
		
		
	}

}
