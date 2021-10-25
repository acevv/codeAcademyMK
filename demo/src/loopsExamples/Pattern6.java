package loopsExamples;

public class Pattern6 {

	public static void main(String[] args) {

		int stars = 7;

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
