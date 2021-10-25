package loopsExamples;

public class Pattern5 {

	public static void main(String[] args) {
		// Stars = broj na redovi na "elkata"
		int stars = 8;

		int counter = 0;

		// eden for za da printa nov red
		for (int i = 1; i <= stars; i++) {
			

			// for za prazni mesta pred prvata zvezda
			for (int j = i; j < stars; j++) {
				System.out.print(" ");
				// counter-ot sluzi da presmeta kolku mesta falat za da se izramni redot i da se
				// napravi polovina elka
				counter++;
			}

			// for koj so pomos na counterot gi dopolnuva mestata za da se izramni redot i
			// napravi polovina elka
			for (int j2 = stars; j2 > counter; j2--) {
				System.out.print("*");

			}
			counter = 0;

			// for za ispisuvanje na polovina obicna elka
			for (int j3 = 1; j3 < i; j3++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
