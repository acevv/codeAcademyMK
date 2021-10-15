package stringToInt;

public class StringToInt {

	public static void main(String[] args) {
		
		
		int n = Integer.parseInt("20");
		
		System.out.println(n + 20);
		
		String s = "age: 47";
		s = s.replaceAll("\\D+", "");
		
		int o = Integer.parseInt(s);
		
		System.out.println(o + 4);
		
		System.out.println(s + 5);
		
				
		

	}

}
