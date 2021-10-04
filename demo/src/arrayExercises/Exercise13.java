package arrayExercises;

public class Exercise13 {

	public static void main(String[] args) {
		String[] niza = { "bcd", "abd", "jude", "bcd", "oiu", "gzq", "oiu" };

		for (int i = 0; i < niza.length; i++) {

			for (int j = i + 1; j < niza.length; j++) {

				if (niza[i].equals(niza[j]) && (i != j)) {
					System.out.println("Duplicate element is: " + niza[j]);
				}
			}
		}
	}

}
