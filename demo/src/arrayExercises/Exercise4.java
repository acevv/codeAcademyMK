package arrayExercises;

// Write a Java program to calculate the average value of array elements
public class Exercise4 {

	public static void main(String[] args) {

		Integer celiBroevi[] = { 3, 4, 5, 7, 9 };
		Float sum = 0f;
		Float srednaVrednost = 0f;

		for (int i = 0; i < celiBroevi.length; i++) {

			sum += celiBroevi[i];

		}

		srednaVrednost = sum / celiBroevi.length;
		System.out.println("The array has: " + celiBroevi.length + " elements, the sum is: " + sum
				+ ", and the average value is: " + srednaVrednost);

	}

}
