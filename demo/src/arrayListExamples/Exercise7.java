package arrayListExamples;

import java.util.ArrayList;

public class Exercise7 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
//		ArrayList<String> colors2 = new ArrayList<>();

		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");

		System.out.println("Original array: " + colors);

		System.out.println(ifContains2(colors, "Black"));

//		System.out.println(ifContains2(colors2, "White"));

	}

	public static String ifContains(ArrayList<String> lista, String element) {

		if (lista.contains(element) == true) {
			return "Bojata postoi vo listata";
		} else {
			return "Bojata ne postoi vo listata";
		}

	}

	public static String ifContains2(ArrayList<String> lista, String element) {

		if (lista.isEmpty()) {
			return "Listata e prazna!";
		} else {

			for (String boja : lista) {
				if (boja == element) {
					return "Bojata postoi vo listata";
				}
			}
		}
		return "Listata e prazna";
	}

}
