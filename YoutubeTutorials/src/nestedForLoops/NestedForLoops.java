package nestedForLoops;

public class NestedForLoops {

	public static void main(String[] args) {

		String[] colors = { "Red", "Blue", "Green" };
		for (int i = 0; i < 3; i++) {
			System.out.println(colors[i]);
		}

		System.out.println("------------------");

		String[][] fancyColors = { { "Red", "Blue", "Green" }, { "Cyan", "Magenta", "Tyrqioise" } };
		
		for(int i = 0; i < 2; i++) {
			for(int j= 0; j < 3; j++) {
				System.out.println(fancyColors[i][j]);
			}
		}
		
		System.out.println("------------------");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println("i: " + i + ",  j: " + j);
		 	}
		}

	}

}
