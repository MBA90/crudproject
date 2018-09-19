package com.mba.crudproject.controller;

import com.mba.crudproject.businessexception.BusinessRuleException;
import com.mba.crudproject.dao.DepartmentDao;
import com.mba.crudproject.dao.jpa.DepartmentDaoImpl;
import com.mba.crudproject.entity.DepartmentEntity;
import com.mba.crudproject.util.Common;

/**
 * Department Controller.
 * 
 * @author MBA
 *
 */
public class DepartmentController {

	/**
	 * Add Department
	 * 
	 * @param department
	 * @return true if department added successfully.
	 * 
	 * @throws BusinessRuleException
	 */
	public boolean addDepartment(DepartmentEntity department) throws BusinessRuleException {

		if (department == null) {
			throw new BusinessRuleException("D-ADD-01", "Department is mandatory");
		}

		if (Common.isBlankOrNull(department.getDeptCode())) {
			throw new BusinessRuleException("D-ADD-02", "Department code is mandatory");
		}

		if (Common.isBlankOrNull(department.getName())) {
			throw new BusinessRuleException("D-ADD-03", "Department name is mandatory");
		}

		if (Common.isBlankOrNull(department.getLocation())) {
			throw new BusinessRuleException("D-ADD-04", "Department location is mandatory");
		}

		DepartmentDao dao = new DepartmentDaoImpl();
		return dao.addDepartment(department);
	}

	/**
	 * Find By Department Code.
	 * 
	 * @param deptCode
	 * @return Department Entity
	 * 
	 * @throws BusinessRuleException
	 */
	public DepartmentEntity findByDeptCode(String deptCode) throws BusinessRuleException {

		DepartmentEntity department;

		if (Common.isBlankOrNull(deptCode)) {
			throw new BusinessRuleException("D-FIND-01", "Department code is mandatory");
		}

		DepartmentDao dao = new DepartmentDaoImpl();
		department = dao.findByDeptCode(deptCode);

		if (department == null) {
			throw new BusinessRuleException("D-FIND-02", "Department is not exist");
		}
		return department;
	}

	/**
	 * Remove Department.
	 * 
	 * @param deptCode
	 * @return true if department removed successfully.
	 * 
	 * @throws BusinessRuleException
	 */
	public boolean removeDepartment(String deptCode) throws BusinessRuleException {

		if (Common.isBlankOrNull(deptCode)) {
			throw new BusinessRuleException("D-REMOVE-01", "Department code is mandatory");
		}

		if (!isDepartmentExist(deptCode)) {
			throw new BusinessRuleException("D-REMOVE-02", "Department code is not exist");
		}

		DepartmentDao dao = new DepartmentDaoImpl();
		return dao.removeDepartment(deptCode);
	}

	/**
	 * Update Department.
	 * 
	 * @param department
	 * @return true if department updated successfully.
	 * 
	 * @throws BusinessRuleException
	 */
	public boolean updateDepartment(DepartmentEntity department) throws BusinessRuleException {

		if (department == null) {
			throw new BusinessRuleException("D-UPDATE-01", "Department is mandatory");
		}

		if (Common.isBlankOrNull(department.getDeptCode())) {
			throw new BusinessRuleException("D-UPDATE-02", "Department code is mandatory");
		}

		if (Common.isBlankOrNull(department.getLocation())) {
			throw new BusinessRuleException("D-UPDATE-03", "Department location is mandatory");
		}

		if (Common.isBlankOrNull(department.getName())) {
			throw new BusinessRuleException("D-UPDATE-04", "Department name is mandatory");
		}

		DepartmentDao dao = new DepartmentDaoImpl();
		return dao.updateDepartment(department);
	}

	/**
	 * Is Department Exist
	 * 
	 * @param deptCode
	 * @return
	 * @throws BusinessRuleException
	 */
	public boolean isDepartmentExist(String deptCode) throws BusinessRuleException {

		if (Common.isBlankOrNull(deptCode)) {
			throw new BusinessRuleException("D-FIND-01", "Department code is mandatory");
		}

		DepartmentDao dao = new DepartmentDaoImpl();
		return dao.isDepartmentExist(deptCode);
	}
}
