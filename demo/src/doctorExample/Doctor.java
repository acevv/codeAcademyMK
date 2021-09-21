package doctorExample;

public class Doctor {

	private String speciality;
	private String name;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getInfo() {
		System.out.println("Doctor name: " + name + ", Speciality: " + speciality);
	}

	public void treatPatient() {
		System.out.println("Doctor " + name + " is checking the patient.");
	}

	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", name=" + name + "]";
	}
	
	// constructor generiran od polinja (fields) vo istata klasa
	public Doctor(String speciality, String name) {
		super();
		this.speciality = speciality;
		this.name = name;
	}

}
