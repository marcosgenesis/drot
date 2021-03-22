package br.com.pi.drot.model;

import java.sql.Date;

public class ConsultaModel {
	private int id;
	private PacienteModel paciente;
	private Date dataConsulta;
	private String descricaoConsulta;
	private MedicoModel medico;

	public ConsultaModel(){}

	public ConsultaModel(int id, PacienteModel paciente, Date dataConsulta, String descricaoConsulta, MedicoModel medico) {
		super();
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

}

