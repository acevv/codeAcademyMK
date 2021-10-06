package arrayListExamples;

import java.util.ArrayList;

public class Exercise22 {

	public static void main(String[] args) {
		ArrayList<String> lista1 = new ArrayList<>();

		lista1.add("Red");
		lista1.add("Green");
		lista1.add("Black");
		lista1.add("White");
		lista1.add("Pink");
		
		
		lista1.trimToSize();
		
		// exercise 20
		lista1.ensureCapacity(9);
		
		

	}

}
