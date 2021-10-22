package loopsExamples;

public class CelsiusToFarenheit {
	// F = 9/5 * Celsius + 32
	
	public static Double celsiusToFarenheit(Integer celsius) {
		Double res = 0.00;
		
		res =  (double) (1.8 * celsius + 32);
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(celsiusToFarenheit(40));
		
	}

}
