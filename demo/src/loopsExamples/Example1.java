package loopsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*vnesete lista vo koja ima 10 broja
	 *da se napishe aplikacija koja kje presmeta kolku vkupno broevi ima, sekoj od niv kolku cifri ima,
	 *dali e paren ili neparen i kolku vkupno broevi imame sho se parni a kolku neparni.
	 *da se presmeta sumata na site parni broevi, soodvetno i sumata na site neparni broevi
	 */
public class Example1 {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();

		numbers.add(156);
		numbers.add(195);
		numbers.add(21);
		numbers.add(87);
		numbers.add(1257);
		numbers.add(96);
		numbers.add(1);
		numbers.add(6);
		numbers.add(7896);
		numbers.add(12345);

		System.out.println("Broevi: " + numbers);

		// 1. Broj na elementi vo nizata
		System.out.println("Vo nizata ima vkupno: " + numbers.size() + " elementi.");

		// 2. Kolku cifri ima sekoj od broevite: [3, 3,2,2,4....]
		ArrayList<Integer> brojCifri = new ArrayList<>();
		brojCifri = countDigits(numbers);
		System.out.println("Sekoj od broevite ima soodvetno " + brojCifri + " cifri");

		// 3. Da se presmeta po kolku broevi imaat isti broj na cifri
		ArrayList<String> istBrojNaCifr = new ArrayList<>();
		istBrojNaCifr = istiBrojNaCifri(brojCifri);
		System.out.println("Ist broj na cifri imaat " + istBrojNaCifr);

		// 4. Kolku parni broevi ima vo listata
		Integer vkupnoParni = parniBroevi(numbers);
		System.out.println("Parni broevi vo listata ima: " + vkupnoParni);
		
		// 5. Lista so parni broevi od listata
		ArrayList<Integer> listaSoParni = new ArrayList<>();
		listaSoParni = listaParniBroevi(numbers);
		System.out.println("Parni broevi vo listata se: "+	 listaSoParni);
		
		// 6. Suma na neparnite broevi
		System.out.println("Sumata na neparnite broevi e: " + sumaNaParni(numbers));
		
		// 7. Hashmapa za kolku cifrri ima
		System.out.println(istiBrojNaCifriMapa(brojCifri));
	}

	// Suma na site parni broevi
	public static Integer sumaNaParni(ArrayList<Integer> lista) {
	
		Integer sum = 0;
		for (Integer broj : lista) {
			if (broj % 2 != 0) {
				sum += broj;
			}
		}
		
		return sum;
	}
	
	// Vrakja lista so site parni broevi
	public static ArrayList<Integer> listaParniBroevi(ArrayList<Integer> lista) {
		ArrayList<Integer> res = new ArrayList<>();

		for (Integer broj : lista) {
			if (broj % 2 == 0) {
				res.add(broj);
			}
		}

		return res;
	}

	// Broi kolku parni broevi ima vo listata
	public static Integer parniBroevi(ArrayList<Integer> lista) {
		Integer counter = 0;

		for (Integer broj : lista) {
			if (broj % 2 == 0) {
				counter++;
			}
		}

		return counter;
	}

	public static ArrayList<String> istiBrojNaCifri(ArrayList<Integer> lista) {
		ArrayList<String> result = new ArrayList<>();
		Integer counter = 0;
		lista.sort(null);

		for (Integer broj : lista) {

			counter = Collections.frequency(lista, broj);
			String temp = "\n" + broj + " cifri: " + counter;

			if (!result.contains(temp)) {
				result.add(temp);
			}

		}
		return result;
	}
	
	public static HashMap<Integer, String> istiBrojNaCifriMapa(ArrayList<Integer> lista) {
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		Integer counter = 0;
		lista.sort(null);

		for (Integer broj : lista) {

			counter = Collections.frequency(lista, broj);
			result.put(broj, counter+" broevi");


		}
		return result;
	}

	public static ArrayList<Integer> countDigits(ArrayList<Integer> lista) {
		ArrayList<Integer> result = new ArrayList<>();
		Integer counter = 0;

		for (Integer broj : lista) {
			do {
				broj /= 10;
				counter++;
			} while (broj != 0);

			result.add(counter);
			counter = 0;
		}
		return result;
	}

}
