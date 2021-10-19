package setExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Cars {
	
	public static void main(String[] args) {
		HashSet<Car> carsSet = new HashSet<>();

		Car bmw = new Car("m535", 2021, "BMW", "Black", CarType.Sedan);
		Car mercedes = new Car("s350", 2019, "Mercedes", "Red", CarType.Hatchbeck);
		carsSet.add(mercedes);
		carsSet.add(bmw);
		
		
		
		System.out.println("HashSet to ArrayList: " + setToArrayCars(carsSet));
		
		
	}
	public static ArrayList<Car> setToArrayCars(HashSet<Car> set){
		ArrayList<Car> res = new ArrayList<>();
		Iterator<Car> i = set.iterator();
		
		while (i.hasNext()) {
			res.add(i.next());
		}
		return res;
		
	}

}

	
