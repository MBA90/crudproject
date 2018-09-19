package com.mba.crudproject.dao;

import com.mba.crudproject.entity.EmployeeEntity;

/**
 * Employee DAO.
 * 
 * @author MBA
 *
 */
public interface EmployeeDao {

	/**
	 * Add Employee
	 * 
	 * @param employee
	 * @return true if entity added successfully.
	 */
	boolean addEmployee(EmployeeEntity employee);

	/**
	 * Find By Employee Code
	 * 
	 * @param empCode
	 * @return employee entity
	 */
	EmployeeEntity findByEmpCode(String empCode);

	/**
	 * Remove Employee
	 * 
	 * @param empCode
	 * @return true if employee removed successfully
	 */
	boolean removeEmployee(String empCode);

	/**
	 * Update Employee
	 * 
	 * @param employee
	 * @return true if employee updated successfully
	 */
	boolean updateEmployee(EmployeeEntity employee);

	/**
	 * Is Employee Exist
	 * 
	 * @param empCode
	 * @return return true if employee exist
	 */
	boolean isEmployeeExist(String empCode);
}
