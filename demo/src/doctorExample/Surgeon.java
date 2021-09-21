package doctorExample;

public class Surgeon extends Doctor {

	// overriden metod od klasata Doctor
	public void treatPatient() {
		System.out.println("Doctor " + this.getName() + " is making a surgery on the patient.");
	}
	
	// constructor generiran od superklasata Doktor
	public Surgeon(String speciality, String name) {
		super(speciality, name);
	}

}
