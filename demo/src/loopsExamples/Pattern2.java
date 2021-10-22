package loopsExamples;

public class Pattern2 {

	public static void main(String[] args) {

		int stars = 7;

		for (int i = stars; i >= 0; i--) {

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
