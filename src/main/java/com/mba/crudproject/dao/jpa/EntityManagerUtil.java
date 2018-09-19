package com.mba.crudproject.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manager Util
 * 
 * Singleton Patterns to allocate one connection instance only.
 * 
 * @author MBA
 *
 */
public class EntityManagerUtil {

	private static EntityManager entityManager;

	/**
	 * Private Constructor
	 */
	private EntityManagerUtil() {
	}

	/**
	 * Get Entity Manager instance. Check whether is there live instance else will
	 * create a new one using entity manager factory.
	 * 
	 * @return entity manager
	 */
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPACrudProject");
			return factory.createEntityManager();
		}
		return entityManager;
	}

}
