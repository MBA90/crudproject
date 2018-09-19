package com.mba.crudproject.dao.jpa;

import javax.persistence.EntityManager;

import com.mba.crudproject.dao.EmployeeDao;
import com.mba.crudproject.entity.EmployeeEntity;

/**
 * Department DAO Implementation.
 * 
 * @author MBA
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/**
	 * Add Employee
	 * 
	 * @param employee
	 * 
	 * @return true if entity added successfully.
	 */
	@Override
	public boolean addEmployee(EmployeeEntity employee) {

		boolean isAdd = false;
		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			if (employee != null) {
				em.getTransaction().begin();
				em.persist(employee);
				em.getTransaction().commit();
				isAdd = true;
			}

		} catch (Exception ex) {
			em.getTransaction().rollback();
			isAdd = false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return isAdd;
	}

	/**
	 * Find By Employee Code
	 * 
	 * @param empCode
	 * @return employee entity
	 */
	@Override
	public EmployeeEntity findByEmpCode(String empCode) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.find(EmployeeEntity.class, empCode);

	}

	/**
	 * Remove Employee
	 * 
	 * @param empCode
	 * @return true if employee removed successfully
	 */
	@Override
	public boolean removeEmployee(String empCode) {

		boolean isRemove = false;
		EmployeeEntity employee;

		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			employee = em.find(EmployeeEntity.class, empCode);

			if (employee != null) {
				em.getTransaction().begin();
				em.remove(employee);
				em.getTransaction().commit();
				isRemove = true;
			} else {
				isRemove = false;
			}
		} catch (Exception ex) {
			em.getTransaction().rollback();
			isRemove = false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return isRemove;
	}

	/**
	 * Update Employee
	 * 
	 * @param employee
	 * @return true if employee updated successfully
	 */
	@Override
	public boolean updateEmployee(EmployeeEntity employee) {

		boolean isUpdate = false;
		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			if (employee != null && employee.getDepartment() != null) {
				EmployeeEntity currentEmployee = em.find(EmployeeEntity.class, employee.getEmpCode());
				em.getTransaction().begin();
				currentEmployee.setAge(employee.getAge());
				currentEmployee.setFirstName(employee.getFirstName());
				currentEmployee.setLastName(employee.getLastName());
				currentEmployee.setDateOfJoining(employee.getDateOfJoining());
				currentEmployee.setDesignation(employee.getDesignation());
				currentEmployee.getDepartment().setDeptCode(employee.getDepartment().getDeptCode());
				em.getTransaction().commit();
				isUpdate = true;
			} else {
				isUpdate = false;
			}
		} catch (Exception ex) {
			em.getTransaction().rollback();
			isUpdate = false;
		}
		return isUpdate;
	}

	/**
	 * Is Employee Exist
	 * 
	 * @param empCode
	 * @return return true if employee exist
	 */
	@Override
	public boolean isEmployeeExist(String empCode) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		EmployeeEntity employee = em.find(EmployeeEntity.class, empCode);

		boolean isExist = (employee == null) ? false : true;
		return isExist;
	}
}
