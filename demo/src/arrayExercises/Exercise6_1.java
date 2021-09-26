package arrayExercises;

// Write a Java program to find the value of a specific index in an array 
public class Exercise6_1 {

	public static Integer findValueOfIndex(Integer array[], Integer index) {
		return array[index];
	}

	public static void main(String[] args) {
		Integer niza[] = { 25, 14, 56, 15, 36, 56, 77, 17, 29, 49 };
		Integer index = 3;

		System.out.println("The value of the index " + index + " is: " + findValueOfIndex(niza, index));

	}

}
