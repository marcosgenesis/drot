package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.model.RemedioModel;
import br.com.pi.drot.model.TratamentoPacienteModel;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class RemedioDTO {
	private Connection connection;

	public RemedioDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public boolean cadastrarRemedio(TratamentoPacienteModel tratamento){
		return false;
	}

	public RemedioModel buscarRemedioPorID(int id){
		return null;
	}

	public ArrayList<RemedioModel> listarRemedio(){
		return null;
	}

	public boolean editar(RemedioModel remedio) {
		return false;
	}

	public boolean removerRemedioPorId(int id) {
		return false;
	}
}
