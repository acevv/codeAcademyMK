package javaBasic2;

public class BreakDown {

	public static void main(String[] args) {
		
		int[] numbers = {10,20,30,40,50};
		
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 30) {
				break;
			}
			System.out.println(numbers[i]);
		}
		
		int i = 0;
		
		switch(i) {
			case 0:
				System.out.println("Zero");
				break;
			case 1:
				System.out.println("One");
				break;
			default:
				System.out.println("WTF?");
				break;
					
		}
		
		for (int j = 0; j < 5; j++) {
			
//			for (int j2 = 0; j2 < 5; j2++) {
//				System.out.println(j + ", " + j2);
//				break;
//			}
		}
		
		
		
	}

}
