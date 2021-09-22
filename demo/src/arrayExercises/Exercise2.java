package arrayExercises;


public class Exercise2 {

	public static void main(String[] args) {

		Integer celiBroevi[] = { 3, 4, 5, 7, 9 };
		int sum = 0;

		for (int i = 0; i < celiBroevi.length; i++) {
			sum += celiBroevi[i];
		}

		System.out.println("Sumata e : " + sum);
		
		// odzemete gi broevite od nizata od nazad
		int odzemi = 0;
		Boolean flag = false;
		
		for (int i = celiBroevi.length - 1; i >= 0; i--) {
			if (flag == true) {
				odzemi -= celiBroevi[i];
			} else {
				flag = true;
				odzemi = celiBroevi[i];
			}
		}
		
		System.out.println("Razlikata od broevite nanazad e : " + odzemi);
	}
}
