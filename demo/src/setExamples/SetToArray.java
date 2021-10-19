package setExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetToArray {

	public static void main(String[] args) {
		HashSet<String> colorsSet = new HashSet<>();
		colorsSet.add("White");
		colorsSet.add("Black");
		colorsSet.add("Red");
		colorsSet.add("Blue");
		
		System.out.println("HashSet of colors: " + colorsSet);
		System.out.println("ArrayList of colors: " + set2array2(colorsSet));
		
	}

	private static ArrayList<String> set2array(HashSet<String> set) {
			ArrayList<String> result =new ArrayList<>();
			for (String string : set) {
				result.add(string);
			}
			return result;
	}
	
	private static ArrayList<String> set2array2(HashSet<String> set) {
		ArrayList<String> result =new ArrayList<>();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		return result;
}
	
	

}
