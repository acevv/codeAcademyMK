package arrayExercises;

// Write a Java program to test if an array contains a specific value
public class Exercise5 {

	public static void main(String[] args) {
		Integer celiBroevi[] = { 1789, 2035, 1899, 1456, 2013 };

		Boolean flag = false;
		int j = 2013;
		for (int i = 0; i < celiBroevi.length; i++) {
			if (j == celiBroevi[i]) {
				flag = true;
			}
		}

		if (flag == true) {
			System.out.println("The array contains the number: " + j);
		} else {
			System.out.println("The array does not contain the number: " + j);
		}

	}

}
