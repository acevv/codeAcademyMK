package org.test.company;

import org.test.company.service.CompanyServiceImpl;

public class App {

	public static void main(String[] args) {
		
		
		CompanyServiceImpl services = new CompanyServiceImpl();
		
		services.openSession();

	}
}
