package org.test.companyHibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dept_locations")
public class DLocation {

	@EmbeddedId
	private DLocationEmbd deptLocation;

	public DLocation() {
		super();
	}

	public DLocation(DLocationEmbd deptLocation) {
		super();
		this.deptLocation = deptLocation;
	}

	public DLocationEmbd getDeptLocPkey() {
		return this.deptLocation;
	}

	public void setDeptLocPkey(DLocationEmbd deptLocation) {
		this.deptLocation = deptLocation;
	}
}
