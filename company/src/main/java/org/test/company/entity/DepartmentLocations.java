
package org.test.company.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "department_locations")
public class DepartmentLocations {

	@EmbeddedId
	private DepartmentLocationsId deptIdLocation;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@MapsId("departmentId")
	private Departmnet department;

	public DepartmentLocationsId getDeptIdLocation() {
		return deptIdLocation;
	}

	public void setDeptIdLocation(DepartmentLocationsId deptIdLocation) {
		this.deptIdLocation = deptIdLocation;
	}

	public Departmnet getDepartment() {
		return department;
	}

	public void setDepartment(Departmnet department) {
		this.department = department;
	}

	public DepartmentLocations(Departmnet department, String location) {
		super();
		this.deptIdLocation = new DepartmentLocationsId(department.getdNumber(), location);

	}

	public DepartmentLocations() {
		super();
	}

}
