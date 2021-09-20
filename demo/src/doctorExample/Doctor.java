package doctorExample;

public class Doctor {

	public String speciality;
	public String name;

	public void getInfo() {
		System.out.println("Doctor name: " + this.name + ", Speciality: " + this.speciality);
	}

	public void treatPatient() {
		System.out.println("Doctor " + this.name + " is checking the patient.");
	}

	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", name=" + name + "]";
	}

	public Doctor(String speciality, String name) {
		super();
		this.speciality = speciality;
		this.name = name;
	}

}
