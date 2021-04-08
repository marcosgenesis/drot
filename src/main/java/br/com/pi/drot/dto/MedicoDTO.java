package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.entity.Paciente;

public class MedicoDTO implements MedicoDAO{

	private Connection connection;

	public MedicoDTO() {
		this.connection = new Connection();
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
