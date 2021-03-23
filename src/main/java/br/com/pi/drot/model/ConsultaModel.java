package br.com.pi.drot.model;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class ConsultaModel extends GenericDAO<ConsultaModel> implements ConsultaDAO {
	private int id;
	private PacienteModel paciente;
	private Date dataConsulta;
	private String descricaoConsulta;
	private MedicoModel medico;
	private Connection connection;

	public ConsultaModel(NameDataBaseConnection nameDataBaseConnection){
        super(Consulta.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public ConsultaModel(int id, PacienteModel paciente, Date dataConsulta, String descricaoConsulta, MedicoModel medico) {
		super(Consulta.class);
		this.id = id;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.descricaoConsulta = descricaoConsulta;
		this.medico = medico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PacienteModel getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteModel paciente) {
		this.paciente = paciente;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}

	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}

	public MedicoModel getMedico() {
		return medico;
	}

	public void setMedico(MedicoModel medico) {
		this.medico = medico;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarConsulta(PacienteModel paciente, MedicoModel medico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remarcarConsulta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean desmarcarConsulta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarConsultaPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

