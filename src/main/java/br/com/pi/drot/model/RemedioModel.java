package br.com.pi.drot.model;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.RemedioDAO;
import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class RemedioModel extends GenericDAO<RemedioModel> implements RemedioDAO{
	private int id;
	private String nomeRemedio;
	private String dosagem;
	private String bula;
	private String contraIndicacao;
	private Connection connection;

	public RemedioModel(NameDataBaseConnection nameDataBaseConnection) {
		super(Remedio.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public RemedioModel(int id, String nomeRemedio, String dosagem, String bula, String contraIndicacao) {
		super(Remedio.class);
		this.id = id;
		this.nomeRemedio = nomeRemedio;
		this.dosagem = dosagem;
		this.bula = bula;
		this.contraIndicacao = contraIndicacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarRemedio(TratamentoPacienteModel tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RemedioModel buscarRemedioPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RemedioModel> listarRemedio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(RemedioModel remedio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerRemedioPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
