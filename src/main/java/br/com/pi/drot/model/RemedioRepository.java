package br.com.pi.drot.model;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.RemedioDAO;
import br.com.pi.drot.entity.Remedio;

public class RemedioRepository extends GenericDAO<RemedioRepository> implements RemedioDAO{
	private Connection connection;

	public RemedioRepository() {
		super(Remedio.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarRemedio(TratamentoPacienteRepository tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RemedioRepository buscarRemedioPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RemedioRepository> listarRemedio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(RemedioRepository remedio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerRemedioPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
