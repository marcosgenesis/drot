package br.com.pi.drot.model;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.entity.Medico;

public class MedicoRepository extends GenericDAO<MedicoRepository> implements MedicoDAO {
	private Connection connection;

	public MedicoRepository() {
		super(Medico.class);
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


