package demo;

import jaxb.*;


public class Main {

	public static void main(String[] args) {
		
		EmployeeJAXB obj = new EmployeeJAXB();
		System.out.println("MARSHALLING!\n");
		obj.marshall();
		System.out.println("\nMarshall SUCCESS!");
		
		System.out.println("______________________________________________________________");
		
		System.out.println("\nUNMARSHALLING!\n");
		obj.unmarshall();
		System.out.println("\nUnmarshall SUCCESS!");
		
	}

}
