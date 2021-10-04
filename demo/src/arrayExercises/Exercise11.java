package arrayExercises;

import java.util.Arrays;

public class Exercise11 {

	public static void main(String[] args) {
//		Integer[] niza = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] niza = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };
		reversedArray(niza);
	}

	private static void reversedArray(Integer[] niza) {
		
		System.out.println("Originalnata niza e: " + Arrays.toString(niza));
		
		for (int i = 0; i < niza.length / 2; i++) {
			Integer temp = niza[i];
			System.out.println("Temp = " + temp);
			
			
			niza[i] = niza[niza.length - i - 1];
			System.out.println("niza[" + i + "] =" +  niza[i]);
			
			niza[niza.length - i - 1] = temp;
			System.out.println("niza[" + (niza.length - i - 1) + "] = " + niza[niza.length - i - 1]);
			
		}
		System.out.println("Prevrtena niza e: " + Arrays.toString(niza));
	}

}
