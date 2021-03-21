package br.com.pi.drot.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Connection {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public Connection(String dataBase) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(dataBase);
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

>>>>>>> ca140107bde4d8de3c619023dc91cd3fed7e6871
}
