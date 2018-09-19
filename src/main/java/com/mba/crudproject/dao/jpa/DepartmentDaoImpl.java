package com.mba.crudproject.dao.jpa;

import javax.persistence.EntityManager;

import com.mba.crudproject.dao.DepartmentDao;
import com.mba.crudproject.entity.DepartmentEntity;

/**
 * Department DAO implementation
 * 
 * @author MBA
 *
 */
public class DepartmentDaoImpl implements DepartmentDao {

	/**
	 * Add Department.
	 * 
	 * @param department
	 * @return true if entity added successfully.
	 */
	@Override
	public boolean addDepartment(DepartmentEntity department) {

		boolean isAdd = false;
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(department);
			em.getTransaction().commit();
			isAdd = true;
			return isAdd;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			return isAdd;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	/**
	 * Find Department By department code
	 * 
	 * @param dept code
	 * @return department entity
	 */
	@Override
	public DepartmentEntity findByDeptCode(String deptCode) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.find(DepartmentEntity.class, deptCode);
	}

	/**
	 * Remove Department
	 * 
	 * @param deptCode
	 * @return true if entity removed successfully.
	 */
	@Override
	public boolean removeDepartment(String deptCode) {
		boolean isRemove = false;
		DepartmentEntity department;

		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			department = em.find(DepartmentEntity.class, deptCode);
			if (department != null) {
				em.getTransaction().begin();
				em.remove(department);
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
	 * Update Department
	 * 
	 * @param department
	 * @return true if entity updated successfully.
	 */
	@Override
	public boolean updateDepartment(DepartmentEntity department) {

		boolean isUpdate = false;
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			if (department != null) {
				DepartmentEntity currentDepartment = em.find(DepartmentEntity.class, department.getDeptCode());
				em.getTransaction().begin();
				currentDepartment.setLocation(department.getLocation());
				currentDepartment.setName(department.getName());
				em.getTransaction().commit();
				isUpdate = true;
			} else {
				return isUpdate = false;
			}
		} catch (Exception ex) {
			em.getTransaction().rollback();
			isUpdate = false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return isUpdate;
	}
}
