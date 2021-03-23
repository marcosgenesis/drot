package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.TratamentoPaciente;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class TratamentoPacienteModel extends GenericDAO<TratamentoPacienteModel> implements TratamentoPacienteDAO{

	private int id;
	private ArrayList<ExameModel> exame;
	private ArrayList<RemedioModel> remedio;
	private Date tempoTratamento;
	private Connection connection;

	public TratamentoPacienteModel(NameDataBaseConnection nameDataBaseConnection){
		super(TratamentoPaciente.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());

	}

	public TratamentoPacienteModel(int id, ArrayList<ExameModel> exame, ArrayList<RemedioModel> remedio, Date tempoTratamento) {
		super(TratamentoPaciente.class);
		this.id = id;
		this.exame = exame;
		this.remedio = remedio;
		this.tempoTratamento = tempoTratamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ExameModel> getExame() {
		return exame;
	}

	public void setExame(ArrayList<ExameModel> exame) {
		this.exame = exame;
	}

	public ArrayList<RemedioModel> getRemedio() {
		return remedio;
	}

	public void setRemedio(ArrayList<RemedioModel> remedio) {
		this.remedio = remedio;
	}

	public Date getTempoTratamento() {
		return tempoTratamento;
	}

	public void setTempoTratamento(Date tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarTratamento(PacienteModel paciente, TratamentoPacienteModel tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TratamentoPacienteModel buscarTratamentoPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TratamentoPacienteModel> listarTratamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(TratamentoPacienteModel tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerTratamentoPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}