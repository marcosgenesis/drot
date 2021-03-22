package br.com.pi.drot.dto;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.PacienteDAO;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class PacienteDTO implements PacienteDAO{

	private Connection connection;

	public PacienteDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void preencherDadosRegistros(String restricaoMedicamental, String doencaHereditaria) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
