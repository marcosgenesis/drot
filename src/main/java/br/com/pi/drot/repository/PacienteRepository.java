package br.com.pi.drot.repository;

import br.com.pi.drot.connection.Connection;

public class PacienteRepository {

	private Connection connection;

	public PacienteRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
