package conditionsLoops;

public class WhileExample {

	public static void main(String[] args) {
		
		Integer i = 2;
		
		while (i < 5) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("----------------------");
		
		
		Integer j = 0;
		
		do {
			System.out.println(j);
			j++;
		} while (j < 5);
		
	}

}
