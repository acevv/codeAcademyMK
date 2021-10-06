package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise14 {

	public static void main(String[] args) {

		ArrayList<String> colors = new ArrayList<>();

		colors.add("Blue");
		colors.add("Red");
		colors.add("White");
		colors.add("Black");
		colors.add("Brown");

		System.out.println("Colors o: " + colors);

		// swap element on index 0 with element on index 2

		Collections.swap(colors, 0, 2);

		System.out.println("Colors m: " + colors);

		// swap element on index 1 with element on index 4
		String t = colors.get(4);
		colors.set(4, colors.get(1));
		colors.set(1, t);

		System.out.println("Colors m: " + colors);
		
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// metod koj kje prima dva argumenti: lista i bojata (String). Treba da vrati
		// Integer so index na bojata

		Collections.shuffle(colors);

		Integer indexWhite = vratiIndex(colors, "White");
		Integer indexBlack = vratiIndex(colors, "Black");
		System.out.println("   Before swap colors: " + colors);
		Collections.swap(colors, indexWhite, indexBlack);
		System.out.println("Swapped white i black: " + colors);
		
		System.out.println(colors.indexOf("White"));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		System.out.println(colors);
		colors.add("6ti element");
		System.out.println(colors);
		System.out.println("Broj na elementi: " + brojNaElementi(colors));
		
		colors.add("7mi element");
		System.out.println(colors);
		System.out.println("Broj na elementi: " + brojNaElementi(colors));
		
		ArrayList<Integer> broevi = new ArrayList<>();
		broevi.add(1);
		broevi.add(2);
		broevi.add(3);
		broevi.add(4);
		broevi.add(5);
		broevi.add(6);
		broevi.add(7);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(broevi);
		System.out.println("Parni broevi: " + totalevenNUmbers( broevi));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(broevi);
		System.out.println("NeParni broevi: " + totalOddNUmbers( broevi));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Parni broevi: " + parniIneparni(broevi).getEven());
		System.out.println("Neparni broevi: " + parniIneparni(broevi).getOdd());
		

	}

	public static Integer vratiIndex(ArrayList<String> lista, String boja) {
		Integer index = 0;
		for (String color : lista) {

			if (boja.equals(color)) {
				return index;
			}
			index++;
		}
		return null;
	}
	
	public static Integer brojNaElementi (ArrayList<String> lista) {
		Integer counter = 0;
		for (String element : lista) {
			counter++;
		}
		return counter;
	}
	// metod sho kje ni kaze kolku parni broevi iamme vo listata
	
	public static Integer totalevenNUmbers(ArrayList<Integer> lista) {
		Integer counter = 0;
		
		for (Integer broj : lista) {
			if (broj % 2 == 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public static Integer totalOddNUmbers(ArrayList<Integer> lista) {
		Integer counter = 0;
		
		for (Integer broj : lista) {
			if (broj % 2 != 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	// metod sto kje vrati objekt koj sodrzi dva parametri (paren i neparen) i kje ni kaze kolku ima parni kolku neparni elementi
	
	public static EvenOdd parniIneparni(ArrayList<Integer> lista) {
		EvenOdd result = new EvenOdd();
		Integer parni = 0;
		Integer neparni = 0;
		
		for (Integer broj : lista) {
			if(broj % 2 == 0) {
				parni++;
			} else { 
				neparni++;
			}
		}
		result.setEven(parni);
		result.setOdd(neparni);
		
		return result;
	}
	
	
	
	
}