package arrayExercises;

import java.util.Arrays;

// TODO resenieto od nizata da se premesti vo nova niza pokratka za eden element
// TODO 11ta i 10ta zadaca da se vidat
public class Exercise7 {

	public static void main(String[] args) {

		Integer[] niza = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };
		System.out.println("Originalna niza: " + Arrays.toString(niza));

		// Odstrani go vtoriot element vo nizata ( index 1 = 14)

		int removeIndex = 1;

		for (int i = removeIndex; i < niza.length - 1; i++) {
			niza[i] = niza[i + 1];

		}
		System.out.println("Modificirana niza: " + Arrays.toString(niza));
		
		
		System.out.println("================================ZADACA 2=============================");
		Integer[] niza2 = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };
		System.out.println(findIndex(14, niza2));
		removeNumber(14, niza2);
		
	}

	public static void removeNumber(Integer n, Integer[] niza) {
		System.out.println("Originalna niza: " + Arrays.toString(niza));

		Integer index = findIndex(n, niza);
		
		for (int i = index; i < niza.length - 1; i++) {
			System.out.println("Niza[" + i + "]" + niza[i] + " = niza[" + (i+1) + "]" + niza[i+1]);
			
			niza [i] = niza [i + 1];
			
		}
		
		Integer novaModificiranaNiza[] = new Integer[9];
		
		for (int i = 0; i < novaModificiranaNiza.length; i++) {
			novaModificiranaNiza[i] = niza[i];
		}
		
		System.out.println("Modificiranata niza: " + Arrays.toString(niza));

		System.out.println("Nova Modificirana niza" + Arrays.toString(novaModificiranaNiza));
		
	}

	private static Integer findIndex(Integer n, Integer[] niza) {
		for (int i = 0; i < niza.length; i++) {
			if (niza[i] == n) {
				return i;
			}
		}
		return null;

	}

}
