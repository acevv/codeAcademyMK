package examples;

public class ExampleSobiranje {

	public static void main(String[] args) {
		
		Integer a = 5;
		Integer b = 6;
		Integer c = 12;
		
		Integer rezultat = 0;
		rezultat = sobiranje(a, b, c);
		System.out.println(rezultat);
		
		rezultat = odzemanje(c,b,a);
		System.out.println(rezultat);
		
		String test = "Tert za testeri";
		System.out.println("Index of s: " + test.indexOf('s'));
		
	}

	private static Integer odzemanje(Integer x, Integer y, Integer z) {
		return x-y-z;
		
		
	}

	private static Integer sobiranje(Integer a, Integer b, Integer c) {

		return a + b + c;
	}

}
