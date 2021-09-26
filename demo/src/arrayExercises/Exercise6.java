package arrayExercises;

public class Exercise6 {

	public static int findIndexOF(int array[], int t) {
		if (array == null)
			return -1;
		int length = array.length;
		int i = 0;
		while (i < length) {
			if (array[i] == t)
				return i;
			else
				i = i + 1;
		}
		return -1;

	}

	public static void main(String[] args) {

		int niza[] = { 25, 14, 56, 15, 36, 56, 77, 17, 29, 49 };

		int number = 17;
		
		if (findIndexOF(niza, number) == -1) {
			System.out.println("The number " + number + " does not exist in the array.");
		} else {
			System.out.println("The index of the element " + number + " is: " + findIndexOF(niza, number));
		}

	}

}
