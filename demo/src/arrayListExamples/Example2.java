package arrayListExamples;

import java.util.ArrayList;
import java.util.Arrays;

public class Example2 {

	public static void main(String[] args) {
		
		String[] array = {"Java", "PHP", "C", "C++"};
		
		
		ArrayList<String> nova = new ArrayList<>(Arrays.asList(array));
		
		System.out.println(nova);

	}

}
