package doctorExample;

public class Doctor {

	public String speciality;
	public String name;

//	public String getSpeciality() {
//		return speciality;
//	}
//
//	public void setSpeciality(String speciality) {
//		this.speciality = speciality;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public void getInfo() {
		
		System.out.println("Doctor name: " + this.name + ", Speciality: " + this.speciality);
		
	}
	
	public void treatPatient() {
		System.out.println("Doctor " + this.name + " is checking the patient.");
	}

}
