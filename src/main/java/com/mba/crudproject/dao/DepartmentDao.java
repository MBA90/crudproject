package com.mba.crudproject.dao;

import com.mba.crudproject.entity.DepartmentEntity;

/**
 * Department DAO.
 * 
 * @author MBA
 *
 */
public interface DepartmentDao {

	/**
	 * Add Department.
	 * 
	 * @param department
	 * @return true if entity added successfully.
	 */
	boolean addDepartment(DepartmentEntity department);

	/**
	 * Find Department By department code
	 * 
	 * @param dept code
	 * @return department entity
	 */
	DepartmentEntity findByDeptCode(String deptCode);
	
	/**
	 * Remove Department
	 * 
	 * @param deptCode
	 * @return true if entity removed successfully.
	 */
	boolean removeDepartment(String deptCode);
	
	/**
	 * Update Department
	 * 
	 * @param department
	 * @return true if entity updated successfully.
	 */
	boolean updateDepartment(DepartmentEntity department);
}
