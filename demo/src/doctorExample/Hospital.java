package doctorExample;

public class Hospital {

	public static void main(String[] args) {

		Doctor doc = new Doctor("Lekar", "John");
		doc.name = "John";
		doc.speciality = "Doctor";
		doc.getInfo();
		doc.treatPatient();

		Surgeon sur = new Surgeon();
		sur.name = "Mike";
		sur.speciality = "Surgeon";
		sur.getInfo(); 		// definiran metod vo Parent klasata Doctor, no moze da go koristi i Child klasata Surgeon
		sur.treatPatient(); // overriden metod vo klasata Surgeon od klasata Doctor

		Doctor dok = new Surgeon(); // dok e od tipot Doctor no moze da gi pristapi metodite od tipot Surgeon
		dok.name = "Ray";
		dok.speciality = "Doctor";
		dok.getInfo();
		dok.treatPatient(); // se povikuva overriden metodot od Child klasata Surgeon
		System.out.println(dok.toString());
		
		// Arrays
		
		Doctor doktori[] = {new Doctor("Stomatolog", "Tome"), new Doctor("Ocen doktor", "Trajce"), new Doctor("Otorinoralingolog", "Zoki")};
		
		for (Doctor doctor : doktori) {
			System.out.println("Ime i prezime: " + doctor.getName());
		}
		
		

	}

}
