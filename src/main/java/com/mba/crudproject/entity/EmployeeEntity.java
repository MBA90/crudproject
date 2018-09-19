package com.mba.crudproject.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Employee entity
 * 
 * @author MBA
 *
 */
@NamedQueries({
		@NamedQuery(name = EmployeeEntity.EMPLOYEE_FIND_ALL, query = "SELECT e from EmployeeEntity e order by e.empCode "), })
@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EMPLOYEE_FIND_ALL = "com.mba.EmployeeEntity.findAll";

	public static final int EMPLOYEE_MIN_AGE = 24;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "emp_code", nullable = false, unique = true)
	@Id
	private String empCode;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "date_of_joining", nullable = false)
	private LocalDate dateOfJoining;

	@Column(name = "designation", nullable = false)
	private String designation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_code")
	private DepartmentEntity department;

	/**
	 * 
	 */

	public EmployeeEntity() {

		department = new DepartmentEntity();
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

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", empCode=" + empCode + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", dateOfJoining=" + dateOfJoining + ", designation=" + designation
				+ ", department=" + department.toString() + "]";
	}

}
