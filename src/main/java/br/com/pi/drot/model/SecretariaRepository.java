package br.com.pi.drot.model;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Secretaria;

public class SecretariaRepository extends GenericDAO<SecretariaRepository>{
	private Connection connection;

	public SecretariaRepository() {
		super(Secretaria.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
