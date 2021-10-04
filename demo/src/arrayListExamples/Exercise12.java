package arrayListExamples;

import java.util.ArrayList;
import java.util.List;

public class Exercise12 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		
		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");
		
		System.out.println("Colors array: " + colors);
		
		List<String> nova = colors.subList(0, 3);
		System.out.println("Nova lista: " + nova);

	}

}
