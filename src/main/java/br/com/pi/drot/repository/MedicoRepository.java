package br.com.pi.drot.repository;

import br.com.pi.drot.connection.Connection;

public class MedicoRepository {
	private Connection connection;

	public MedicoRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}


