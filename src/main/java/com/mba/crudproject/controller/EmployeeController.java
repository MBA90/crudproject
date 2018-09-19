package com.mba.crudproject.controller;

import java.time.LocalDate;

import com.mba.crudproject.businessexception.BusinessRuleException;
import com.mba.crudproject.dao.EmployeeDao;
import com.mba.crudproject.dao.jpa.EmployeeDaoImpl;
import com.mba.crudproject.entity.EmployeeEntity;
import com.mba.crudproject.util.Common;

/**
 * Employee Controller.
 * 
 * @author MBA
 *
 */
public class EmployeeController {

	private DepartmentController departmentController = new DepartmentController();

	/**
	 * Add Employee.
	 * 
	 * @param employee
	 * @return true if employee added successfully
	 * @throws BusinessRuleException
	 */
	public boolean addEmployee(EmployeeEntity employee) throws BusinessRuleException {

		if (employee == null) {
			throw new BusinessRuleException("E-ADD-01", "Employee is mandatory");
		}

		if (Common.isBlankOrNull(employee.getEmpCode())) {
			throw new BusinessRuleException("E-ADD-02", "Employee code is mandatory");
		}
		
		if (isEmployeeExist(employee.getEmpCode())) {
			throw new BusinessRuleException("E-ADD-03", "Employee code is already exist");
		}

		if (Common.isBlankOrNull(employee.getFirstName())) {
			throw new BusinessRuleException("E-ADD-04", "Employee first name is mandatory");
		}

		if (Common.isBlankOrNull(employee.getLastName())) {
			throw new BusinessRuleException("E-ADD-05", "Employee last name is mandatory");
		}

		if (employee.getAge() < EmployeeEntity.EMPLOYEE_MIN_AGE) {
			throw new BusinessRuleException("E-ADD-06", "Employee minimumm age is" + EmployeeEntity.EMPLOYEE_MIN_AGE);
		}

		if (Common.isBlankOrNull(employee.getDesignation())) {
			throw new BusinessRuleException("E-ADD-07", "Employee designation is mandatory");
		}

		if (employee.getDateOfJoining() == null) {
			throw new BusinessRuleException("E-ADD-08", "Employee date of joining is mandatory");
		}

		if (employee.getDateOfJoining().isAfter(LocalDate.now())) {
			throw new BusinessRuleException("E-ADD-09",
					"Employee date of joining should be less than or equal today's date");
		}

		if (employee.getDepartment() != null && Common.isBlankOrNull(employee.getDepartment().getDeptCode())) {
			throw new BusinessRuleException("E-ADD-20", "Employee department code is mandatory");
		}

		if (!Common.isBlankOrNull(employee.getDepartment().getDeptCode())) {
			boolean isExist = departmentController.isDepartmentExist(employee.getDepartment().getDeptCode());
			if (!isExist) {
				throw new BusinessRuleException("E-ADD-12", "Department is not exist");
			}
		}

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.addEmployee(employee);
	}

	/**
	 * FInd BY Employee Code
	 * 
	 * @param empCode
	 * @return Employee Entity
	 * @throws BusinessRuleException
	 */
	public EmployeeEntity findByEmpCode(String empCode) throws BusinessRuleException {

		if (Common.isBlankOrNull(empCode)) {
			throw new BusinessRuleException("E-FIND-01", "Employee code is mandatory");
		}

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		EmployeeEntity employee = employeeDao.findByEmpCode(empCode);

		if (employee == null) {
			throw new BusinessRuleException("E-FIND-02", "Employee is not exist");
		}

		return employee;
	}

	/**
	 * Remove Employee.
	 * 
	 * @param empCode
	 * @return true if employee removed successfully
	 * @throws BusinessRuleException
	 */
	public boolean removeEmployee(String empCode) throws BusinessRuleException {

		if (Common.isBlankOrNull(empCode)) {
			throw new BusinessRuleException("E-REMOVE-01", "Employee code is mandatory");
		}
		
		if (!isEmployeeExist(empCode)) {
			throw new BusinessRuleException("E-REMOVE-02", "Employee code is not exist");
		}

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.removeEmployee(empCode);
	}

	/**
	 * Update Employee.
	 * 
	 * @param employee
	 * @return true if employee updated successfully
	 * @throws BusinessRuleException
	 */
	public boolean updateEmployee(EmployeeEntity employee) throws BusinessRuleException {

		if (employee == null) {
			throw new BusinessRuleException("E-UPDATE-01", "Employee is mandatory");
		}

		if (Common.isBlankOrNull(employee.getEmpCode())) {
			throw new BusinessRuleException("E-UPDATE-02", "Employee code is mandatory");
		}
		
		if (employee.getAge() < EmployeeEntity.EMPLOYEE_MIN_AGE) {
			throw new BusinessRuleException("E-UPDATE-03",
					"Employee minimumm age is " + EmployeeEntity.EMPLOYEE_MIN_AGE);
		}

		if (Common.isBlankOrNull(employee.getFirstName())) {
			throw new BusinessRuleException("E-UPDATE-04", "Employee first name is mandatory");
		}

		if (Common.isBlankOrNull(employee.getLastName())) {
			throw new BusinessRuleException("E-UPDATE-05", "Employee last name is mandatory");
		}

		if (Common.isBlankOrNull(employee.getLastName())) {
			throw new BusinessRuleException("E-UPDATE-06", "Employee last name is mandatory");
		}

		if (Common.isBlankOrNull(employee.getDesignation())) {
			throw new BusinessRuleException("E-UPDATE-07", "Employee designation is mandatory");
		}

		if (employee.getDateOfJoining() == null) {
			throw new BusinessRuleException("E-`UPDATE-08", "Employee date of joining is mandatory");
		}

		if (employee.getDateOfJoining().isAfter(LocalDate.now())) {
			throw new BusinessRuleException("E-UPDATE-09",
					"Employee date of joining should be less than or equal today's date");
		}

		if (employee.getDepartment() != null && Common.isBlankOrNull(employee.getDepartment().getDeptCode())) {
			throw new BusinessRuleException("E-UPDATE-10", "Employee department code is mandatory");
		}

		if (!Common.isBlankOrNull(employee.getDepartment().getDeptCode())) {
			boolean isExist = departmentController.isDepartmentExist(employee.getDepartment().getDeptCode());
			if (!isExist) {
				throw new BusinessRuleException("E-UPDATE-11", "Department is not exist");
			}
		}

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.updateEmployee(employee);
	}

	/**
	 * Is Department Exist
	 * 
	 * @param deptCode
	 * @return
	 * @throws BusinessRuleException
	 */
	public boolean isEmployeeExist(String empCode) throws BusinessRuleException {

		if (Common.isBlankOrNull(empCode)) {
			throw new BusinessRuleException("E-FIND-01", "Employee code is mandatory");
		}

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.isEmployeeExist(empCode);
	}
}
