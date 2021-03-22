package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.PacienteDAO;
import br.com.pi.drot.entity.Paciente;

public class PacienteDTO implements PacienteDAO{

	private Connection connection;

	public Connection getConnection() {
		return connection;
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
