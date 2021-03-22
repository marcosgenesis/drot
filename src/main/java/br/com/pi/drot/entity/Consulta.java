package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.pi.drot.interfaces.IConsulta;

@Entity
@Table(name = "Consulta")
public class Consulta implements IConsulta{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "paciente_id")
	private Paciente paciente;

	@Column(name = "dataConsulta")
	private Date dataConsulta;

	@Column(name = "descricaoConsulta")
	private String descricaoConsulta;

	@Column(name = "medico_id")
	private Medico medico;

	public Consulta(){}

	public Consulta(int id, Paciente paciente, Date dataConsulta, String descricaoConsulta, Medico medico) {
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public boolean marcarConsulta() {
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

}

