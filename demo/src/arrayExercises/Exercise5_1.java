package arrayExercises;

public class Exercise5_1 {

	public static void main(String[] args) {
		Integer celiBroevi[] = { 1789, 2035, 1899, 1456, 2013 };

		System.out.println(contains(1899, celiBroevi));

	}

	public static Boolean contains(Integer number, Integer[] array) {
		
		for (int i = 0; i < array.length; i++) {
		
			if (number.equals(array[i]) ) {
				System.out.println("Brojot " + number + " go ima");
				return true;
			}
			
			System.out.println("Brojot go nema");
		}
		return false;
	}
}
