package com.mba.crudproject.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department entity
 * 
 * @author MBA
 *
 */
@Entity
@Table(name = "department")
public class DepartmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Id
	@Column(name = "dept_code", nullable = false, unique = true)
	private String deptCode;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "location", nullable = false)
	private String location;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<EmployeeEntity> employeeList;

	/**
	 * Constructor
	 */

	public DepartmentEntity() {
		employeeList = new ArrayList<EmployeeEntity>();
	}

	/**
	 * Setters & Getters
	 */

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EmployeeEntity> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeEntity> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", deptCode=" + deptCode + ", name=" + name + ", location=" + location
				+ "]";
	}

}
