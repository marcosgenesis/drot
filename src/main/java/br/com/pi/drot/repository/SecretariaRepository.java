package br.com.pi.drot.repository;

import br.com.pi.drot.connection.Connection;

public class SecretariaRepository {
	private Connection connection;

	public SecretariaRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
