package hashMapExamples;

import java.util.HashMap;

public class Example1 {

	public static void main(String[] args) {
		HashMap<String, String> mapa = new HashMap<String, String>();
		
		mapa.put("Name", "Suzuki");
		mapa.put("Power", "220");
		
		System.out.println(mapa);
		
		System.out.println(mapa.entrySet());
		System.out.println(mapa.get("Name"));
	}

}
