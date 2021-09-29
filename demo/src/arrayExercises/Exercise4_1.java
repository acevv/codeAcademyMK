package arrayExercises;

public class Exercise4_1 {

	public static void main(String[] args) {
		Integer[] niza = {3,4,5,7,9};

		System.out.println("Sumata e "+ sum(niza));
		System.out.println("Srednata vrednost e " + average(niza));

	}

	public static Double average(Integer niza[]) {
		Double result = 0.0;
		Double sum = sum(niza);
		result = (sum / niza.length);
		return result;
	}
	
	public static Double sum(Integer niza[]) {
		Double sum = 0.0;
		
		for(int i = 0; i < niza.length; i++) {
			sum += niza[i];
		}
		return sum;
	}
	
}
