package arrayListExamples;

import java.util.ArrayList;

public class Exercise16 {

	public static void main(String[] args) {
		ArrayList<String> lista1 = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
	
		
		lista1.add("Red");
		lista1.add("Green");
		lista1.add("Black");
		lista1.add("White");
		lista1.add("Pink");
		
		result = (ArrayList<String>) lista1.clone();
		
		
		
		System.out.println("Result: " + result);
	
	
		
		result.removeAll(lista1);
		System.out.println("Isprazneta e result: " + result);
		 
	}
	


}
