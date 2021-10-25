package filesOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextFileToJava {

	public static void main(String[] args) throws IOException {

		String filePath = "resources/data.txt";

		HashMap<String, String> result = new HashMap<String, String>();
		BufferedReader br = null;

		File file = new File(filePath);

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line = null;

		try {
			while ((line = br.readLine()) != null) {
				String[] elements = line.split("=");
				result.put(elements[0], elements[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Map: " + result);

		User u = new User();
		u.setName(result.get("name"));
		u.setSurname(result.get("surname"));
//		u.setAddress(result.get("address"));
		u.setEmail(result.get("email"));
		u.setPhone(result.get("phone"));
//		System.out.println(u);

		HashMap<String, String> mapa = txtToMap(filePath);
 
		User user2 = new User();

		// vaka se povikuva metodot na sekoj setter - podobro e da se instancira vo mapa
		// HashMap<String, String> userMap = txtToMap(filePath); ; vaka samo ednase se
		// povikuva
		// userMap.get("name");
		user2.setName(txtToMap(filePath).get("name"));
//		System.out.println(user2);
		
		Address adresaOdFile = new Address();
		adresaOdFile.setCity(mapa.get("address.city"));
		adresaOdFile.setNumber(Integer.parseInt(mapa.get("address.number")));
		
//		Address addr3 = new Address("Strimica", 49, "Partizanska");
		User user3 = new User("Mite", "Mitev", "076666888", adresaOdFile, "mail@email.com");
		System.out.println(user3);
		
		
		


	}

	public static HashMap<String, String> txtToMap(String filePath) throws IOException {

		HashMap<String, String> result = new HashMap<String, String>();

		BufferedReader br = null;

		File file = new File(filePath);

		br = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] elements = line.split("=");
			result.put(elements[0], elements[1]);
		}
		br.close();

		return result;
	}

}
