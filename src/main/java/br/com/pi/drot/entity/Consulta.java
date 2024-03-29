package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@NamedQuery(name = "Consulta.getById", query = "SELECT c FROM Consulta c WHERE c.codconsulta = :id")
@Entity
@Table(name = "Consulta")
public class Consulta{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codconsulta")
	private int id;

	@Column(name = "cod_paciente")
	private int paciente;

	@Column(name = "data_consulta")
	private String dataConsulta;

	@Column(name = "descricao")
	private String descricaoConsulta;

	@Column(name = "cod_medico")
	private int medico;

	@Column(name = "classificacaoUrgencia")
	private String classificacaoUrgencia;

	@Column(name = "consultaRealizada")
	private boolean consultaRealizada;

	@Column(name = "andamentoConsulta")
	private String andamentoConsulta;

	@Column(name = "consultorioConsulta")
	private String consultorioConsulta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}

	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}

	public boolean getConsultaRealizada(){
		return consultaRealizada;
	}

	public void setConsultaRealizada(boolean consultaRealizada){
		this.consultaRealizada = consultaRealizada;
	}

	public String getClassificacaoUrgencia(){
		return classificacaoUrgencia;
	}

	public void setClassificacaoUrgencia(String classificacaoUrgencia){
		this.classificacaoUrgencia = classificacaoUrgencia;
	}

	public String getAndamentoConsulta() {
		return andamentoConsulta;
	}

	public void setAndamentoConsulta(String andamentoConsulta) {
		this.andamentoConsulta = andamentoConsulta;
	}

	public String getConsultorioConsulta() {
		return consultorioConsulta;
	}

	public void setConsultorioConsulta(String consultorioConsulta) {
		this.consultorioConsulta = consultorioConsulta;
	}

}

