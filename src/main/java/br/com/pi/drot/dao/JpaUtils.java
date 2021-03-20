package br.com.pi.drot.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = null;


	public static EntityManagerFactory getEntityManager() {
		if(ENTITY_MANAGER_FACTORY == null) {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("myself-mysql");
		}

		return (EntityManagerFactory) ENTITY_MANAGER_FACTORY.createEntityManager();
	}
}
