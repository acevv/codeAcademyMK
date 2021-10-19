package conditionsLoops;

public class SwitchCaseExample {

	public static void main(String[] args) {
		Integer num = 3;
		
		switch (num) {
		case 0:
			System.out.println("Zero");
			break;
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3: 
			System.out.println("three");
			break;

		default:
			System.out.println("Greska");
			break;
		}
		
		String number =  "two";
		
		switch (number) {
		case "one":
			System.out.println(1);
			break;
		case "two":
			System.out.println(2);
			break;
		case "three":
			System.out.println(3);
			break;
			
		default:
			System.out.println("Does not exist");
			break;
		}
	}

}
