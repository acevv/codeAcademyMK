package jaxb;

import javax.xml.bind.*;
import java.io.*;

public class EmployeeJAXB {

	public void marshall() {

		try {

			Employee emp = new Employee("A001", "Aleksandar", "Strumica", 50000);
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(emp, System.out);
			ms.marshal(emp, new File("src/data/employee.xml"));

		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}

	public void unmarshall() {
		try {

			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Unmarshaller ums = context.createUnmarshaller();
			Employee emp = (Employee) ums.unmarshal(new File("src/data/employee.xml"));
			System.out.println("Employee information");
			System.out.println("id: " + emp.getId());
			System.out.println("name: " + emp.getName());
			System.out.println("locatioN: " + emp.getAddress());
			System.out.println("salary: " + emp.getSalary());

		} catch (JAXBException e) {
			System.out.println("" + e.getMessage());

		}

	}

}
