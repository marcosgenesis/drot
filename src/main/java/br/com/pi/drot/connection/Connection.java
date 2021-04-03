package br.com.pi.drot.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Connection {

	private static Connection connection;
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DROT");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	private Connection() {
		Connection.connection = new Connection();
	}


	public static Connection getConnection() {
		if(connection == null) {
			synchronized(Connection.class) {
				if(connection == null) {
					connection = new Connection();
				}
			}
		}
		return connection;
	}

	private EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
