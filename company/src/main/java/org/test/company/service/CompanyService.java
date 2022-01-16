package org.test.company.service;

import org.hibernate.Session;

public interface CompanyService {

	public Session openSession();

	public void addData();

}
