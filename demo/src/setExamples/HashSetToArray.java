package setExamples;

import java.util.HashSet;

public class HashSetToArray {

	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<>();
		hash.add("Red");
		hash.add("Blue");
		hash.add("Yellow");
		
		System.out.println("HashSet: "+hash);
		
		// create an array
		String array[] = new String[hash.size()];
		hash.toArray(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Element "+i+" from the array is: "+array[i]);
		}
		
		
	}

}
