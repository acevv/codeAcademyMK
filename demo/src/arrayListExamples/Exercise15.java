package arrayListExamples;

import java.util.ArrayList;

public class Exercise15 {

	public static void main(String[] args) {
		ArrayList<String> lista1 = new ArrayList<>();
		ArrayList<String> lista2 = new ArrayList<>();
		ArrayList<String> results = new ArrayList<>();
		
		lista1.add("Red");
		lista1.add("Green");
		lista1.add("Black");
		lista1.add("White");
		lista1.add("Pink");
		
		lista2.add("Red");
		lista2.add("Green");
		lista2.add("Black");
		lista2.add("Pink");

		System.out.println("Lista 1: " + lista1);
		System.out.println("Lista 2: " + lista2);
		
		results.addAll(lista1);
		results.addAll(lista2);
		
		System.out.println("Dvete zaedno: " + results);
		
		System.out.println("==========++++============================");
		
		System.out.println(merge(lista1, lista2));
	}
	
	public static ArrayList<String> merge(ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList<String> results = new ArrayList<>();
		for (String element : lista1) {
			results.add(element);
		}
		for (String element : lista2) {
			results.add(element);
		}
		
		// ili vaka
//		results.addAll(lista1);
//		results.addAll(lista2);
		
		
		return results;
	}

}
