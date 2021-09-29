package arrayExercises;

import java.util.Arrays;

public class NizaPrimer {

	public static void main(String[] args) {
		Integer celiBroevi[] = { 1789, 2035, 1899, 1456, 9999, 3123, 3045, 2013, 1458, 2458, 1254, 1472, 2365, 1456,
				2165, 1457, 2456 };
		// da se izvadat site broevi od eden range FROM, TO vo nova niz, pritoa da
		// presmeteame kolku broevi ima takvi za da ja utvrdime dolzinata na nizata

		// 1. metod so argumenti FROM i TO
	
		System.out.println(Arrays.toString(fromTo(1800, 2000, celiBroevi)));

	}

	public static Integer[] fromTo(Integer from, Integer to, Integer[] niza) {
		
		Integer rezLength = countNumbers(from, to, niza);
		
		Integer rez[] = new Integer[rezLength];
		Integer j = 0;
		
		for (int i = 0; i < rez.length; i++) {
			
			rez[j] = niza[i];
			j++;
		}
		
		
		return rez;
		
	}

	public static Integer countNumbers(Integer from, Integer to, Integer[] niza) {
		Integer res = 0;
		
		for (int i = 0;  i < niza.length; i++) {
			
			if (niza[i] > from && niza[i] < to) {
				res++;
			}
				
		} 
		
		return res;
	}

}
