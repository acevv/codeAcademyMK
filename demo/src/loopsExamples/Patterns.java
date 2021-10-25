package loopsExamples;

public class Patterns {

	public static void main(String[] args) {

		zvezdiNaLevo(8);
		zvezdiNaDesno(8);
		zvezdiNaSredina(8);

	}

	private static void zvezdiNaLevo(int stars) {
		for (int i = 1; i <= stars; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void zvezdiNaDesno(int stars) {

		for (int i = 1; i <= stars; i++) {

			for (int j = stars; j > i; j--) {
				System.out.print(" ");
			}
			for (int j2 = 0; j2 < i; j2++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	private static void zvezdiNaSredina(int stars) {

		for (int i = 1; i <= stars; i++) {

			for (int j = stars; j > i; j--) {
				System.out.print(" ");
			}
			for (int j2 = 0; j2 < i; j2++) {
				System.out.print("*");
			}

			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
