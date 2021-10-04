package arrayExercises;

public class Exercise10 {

	public static void main(String[] args) {

		Integer[] niza = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 99 };

		minMax(niza);

	}

	public static void minMax(Integer[] niza) {

		Integer max = niza[0];
		Integer min = niza[0];
		Integer size = niza.length;

		for (int i = 1; i <= niza.length - 1; i = i + 2) {
			System.out.println(i);
			// prva proverka - dali e posleden element
			if ((i + 1) == size) {
				if (niza[i] > max) {
					max = niza[i];
				}
				if (niza[i] < min) {
					min = niza[i];
				}
			} else {

				// vtora proverka - ako leviot(i) e pogolem od desniot(i+1) element
				if (niza[i] > niza[i + 1]) {
					if (niza[i] > max) {
						max = niza[i];
					}
					if (niza[i + 1] < min) {
						min = niza[i];
					}
				}

				// treta proverka - ako leviot(i) e pomal od desniot(i+1) element
				if (niza[i] < niza[i + 1]) {
					if (niza[i] < min) {
						min = niza[i];
					}
					if (niza[i + 1] > max) {
						max = niza[i + 1]; 
					}
				}
			}

		}

		System.out.println("Minimumot vo nizata e: " + min);
		System.out.println("Maximumot vo nizata e: " + max);

	}

}
