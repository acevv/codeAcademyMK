package loopsExamples;

public class Pattern3 {

	public static void main(String[] args) {

		int stars = 7;

		for (int i = 1; i <= stars; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}

	}

}
