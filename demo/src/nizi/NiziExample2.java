package nizi;

public class NiziExample2 {

	public static void main(String[] args) {
		
		Integer array[] = new Integer[10];
		
		// array = [1,2,3,4,5,6]
		// 0 e starting point na ciklusot, vtoriot clen e do koga ke vrti - dodeka i e pomalo od array.length
		// tretiot clen e kako da progresira ciklusot i++ - faktor na progresija na ciklusot - inkrementiranje
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.println("i = " + i + "\nArray[" + i + "]=" + array[i]);
		}
		
		array[0] = array[0] + 10;
		array[1] = array[1] + 10;
		
		for (int i=0; i < array.length; i++) {
			System.out.println("i = " + i + "\nArray[" + i + "]=" + array[i]);
		}
		

	}
	
	

}
