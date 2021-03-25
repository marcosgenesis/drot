package br.com.pi.drot.model;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Paciente;

public class PacienteRepository extends GenericDAO<PacienteRepository>{

	private Connection connection;

	public PacienteRepository() {
		super(Paciente.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
