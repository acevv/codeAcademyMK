package doctorExample;

public class Surgeon extends Doctor {

	// overriden metod od klasata Doctor
	public void treatPatient() {
		System.out.println("Doctor " + name + " is making a surgery on the patient.");
	}

}
