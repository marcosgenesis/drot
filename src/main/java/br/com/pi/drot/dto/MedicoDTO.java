package br.com.pi.drot.dto;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class MedicoDTO implements MedicoDAO{

	private Connection connection;

	public MedicoDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void consultarPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarHistoricoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarHistoricoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void criarTratamentodoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarTratamentodoPaciente() {
		// TODO Auto-generated method stub

	}


}
