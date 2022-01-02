package smallExercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Hobbies {

	private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

	public void add(String hobbyist, String... hobbies) {
		this.hobbies.put(hobbyist, hobbies);
	}

	private List<String> findAllHobbyists(String string) {
		List<String> res = new ArrayList<>();
		Set<String> set = hobbies.keySet();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			String k = i.next();
			String[] b;
			b = hobbies.get(k);
			for (int j = 0; j < b.length; j++) {
				if (b[j].equals(string)) {
					res.add(k);
				}
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "Hobbies [hobbies=" + hobbies.keySet() + "values" + hobbies.values() + "]";
	}

	public static void main(String[] args) {
		Hobbies hobbies = new Hobbies();
		hobbies.add("Steve", "Fashion", "Piano", "Reading");
		hobbies.add("Patty", "Drama", "Magic", "Pets");
		hobbies.add("Chad", "Puzzles", "Pets", "Yoga");

		System.out.println(hobbies.findAllHobbyists("Pets"));

	}

}