package br.com.pi.drot.dto;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.model.MedicoModel;
import br.com.pi.drot.model.PacienteModel;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class ConsultaDTO implements ConsultaDAO{

	private Connection connection;

	public ConsultaDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean cadastrarConsulta(PacienteModel paciente, MedicoModel medico){
		return false;
	}

	public boolean remarcarConsulta(){
		return false;
	}

	public boolean desmarcarConsulta(){
		return false;
	}

	public boolean buscarConsultaPorId(int id){
		return false;
	}

}
