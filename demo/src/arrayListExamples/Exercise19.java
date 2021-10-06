package arrayListExamples;

import java.util.ArrayList;

public class Exercise19 {

	public static void main(String[] args) {
		ArrayList<String> lista1 = new ArrayList<>();

		lista1.add("Red");
		lista1.add("Green");
		lista1.add("Black");
		lista1.add("White");
		lista1.add("Pink");
		lista1.add("Yellow");
		
		
		for (int i = 0; i < lista1.size(); i++) {
			System.out.println("Index: " + i + " Value: " + lista1.get(i));
			
		}
 		

	}

}
