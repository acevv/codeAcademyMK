package doctorExample;

public class Hospital {

	public static void main(String[] args) {

		Doctor doc = new Doctor("Lekar", "John");
		doc.getInfo();
		doc.treatPatient();
		System.out.println(doc.toString());

		System.out.println("=======================================================================");

		Surgeon sur = new Surgeon("Hirurg", "Mike");
		sur.getInfo(); // definiran metod vo Parent klasata Doctor, no moze da go koristi i Child klasata Surgeon				
		sur.treatPatient(); // Overridden metod vo klasata Surgeon od klasata Doctor
		System.out.println(sur.toString());

		System.out.println("=======================================================================");

		Doctor dok = new Surgeon("Kardiolog", "Zan"); // dok e od tipot Doctor no moze da gi pristapi metodite od
															// tipot
															// Surgeon
		dok.getInfo();
		dok.treatPatient(); // se povikuva overriden metodot od Child klasata Surgeon
		System.out.println(dok.toString());

		System.out.println("=======================================================================");
		// Arrays

		Doctor doktori[] = { new Doctor("Stomatolog", "Tom"), new Doctor("Otorinolaringolog", "Jay"),
				new Doctor("Otorinoralingolog", "Zane"), doc, sur, dok };

		for (Doctor doctor : doktori) {
			System.out.println("Ime i prezime: " + doctor.getName());
		}

	}

}
