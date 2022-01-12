package org.test.company.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department_locations")
public class DepartmentLocations {

	@EmbeddedId
	private DepartmentLocationsId deptIdLocation;


	

	public DepartmentLocations() {
		super();
	}

	public DepartmentLocations(DepartmentLocationsId deptIdLocation) {
	super();
	this.deptIdLocation = deptIdLocation;
}

	public DepartmentLocationsId getDeptIdLocation() {
		return deptIdLocation;
	}

	public void setDeptIdLocation(DepartmentLocationsId deptIdLocation) {
		this.deptIdLocation = deptIdLocation;
	}

}
