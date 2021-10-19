package setExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Example1 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		
		set.add("White");
		set.add("Black");
		set.add("Red");
		set.add("Blue");
		set.add("Blue");
		set.add(null);
		
		Iterator<String> i = set.iterator();
		
		while (i.hasNext()) {
			String string = (String) i.next();
			System.out.println(string);
		}
		
		System.out.println(set);
		
		
		ArrayList<String> lista = new ArrayList<>();
		lista.add("eden");
		lista.add("dva");
		lista.add("tri");
		
		for (String element : lista) {
			System.out.println(element);
		}
		
		
	}

}
