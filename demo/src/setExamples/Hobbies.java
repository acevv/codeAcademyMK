package setExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Hobbies {
	
	
	private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
	
	
	public void add (String hobbyst, String... hobbies ) {
		this.hobbies.put(hobbyst, hobbies);
	}
	
	public List<String> findAllHobbyists(String hobby) {
		
		
		List<String> result = new ArrayList<String>();
		
		
		for (String key : hobbies.keySet()) {
			for (String value : hobbies.get(key)) {
				if (value.equals(hobby)) {
					result.add(key);
				}
			}
		}
		
		return result;
	}
	

	@Override
	public String toString() {
		return "Hobbies [hobbies=" + hobbies + "]";
	}

	public static void main(String[] args) {
		Hobbies hobbies = new Hobbies();
		hobbies.add("Steve", "Fashion", "Magic", "Reading");
		hobbies.add("Patty", "Drama", "Magic", "Pets");
		hobbies.add("Chad", "Puzzles", "Pets", "Yoga");
		

		System.out.println(Arrays.toString(hobbies.findAllHobbyists("Magic").toArray()));
		
	}

}
