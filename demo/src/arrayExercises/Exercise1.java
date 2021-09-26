package arrayExercises;

import java.util.Arrays;

public class Exercise1 {

	public static Integer largeNumCount(Integer[] input) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			int counter = 0;
			if (input[i] > 2000) {
				counter++;
				counter = count;

			}
			count = counter;
		}
		return count;
	}

	public static void main(String[] args) {

		// Sortirajte gi nizite
		Integer celiBroevi[] = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1465, 2165, 1457, 2456 };

		String tekst[] = { "Java", "Python", "C#", "C", "C++" };

		System.out.println(Arrays.toString(celiBroevi));
		System.out.println(Arrays.toString(tekst));

		Arrays.sort(celiBroevi);
		System.out.println(Arrays.toString(celiBroevi));

		Arrays.sort(tekst);
		System.out.println(Arrays.toString(tekst));

		// TO-DO dodadete metod za broenje na broevi pogolemi od 2000 i deklarirajte
		// ja dolzinata na nizata so nego
		// Izdvoj gi vo posebna niza site broevi sto se pogolemi od 2000
		
		largeNumCount(celiBroevi);
		
		
		Integer pogolemiBroevi[] = new Integer[6];
		int j = 0;

		for (int i = 0; i < celiBroevi.length; i++) {
			if (celiBroevi[i] >= 2000) {
				pogolemiBroevi[j] = celiBroevi[i];
				j++;

			}

		}
		System.out.println(Arrays.toString(pogolemiBroevi));

	}

}
