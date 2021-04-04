package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "TratamentoPaciente.getById", query = "SELECT t FROM TratamentoPaciente t WHERE t.id =: cod")
@Entity
@Table(name = "TratamentoPaciente")
public class TratamentoPaciente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codtratamento")
	private int id;

	@Column(name = "cod_paciente")
	private int paciente;

	@Column(name = "cod_exame")
	private int exame;

	@Column(name = "cod_remedio")
	private int remedio;

	@Column(name = "duracaoDiasTratamento")
	private int duracaoDiasTratamento;
	
	@Column(name = "dataInicioTratamento")
	private String dataInicioTratamento;


	public int getId() {
		return id;
	}

	public int getDuracaoDiasTratamento() {
		return duracaoDiasTratamento;
	}

	public void setDuracaoDiasTratamento(int duracaoDiasTratamento) {
		this.duracaoDiasTratamento = duracaoDiasTratamento;
	}

	public String getDataInicioTratamento() {
		return dataInicioTratamento;
	}

	public void setDataInicioTratamento(String dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public int getPaciente() {
		return this.paciente;
	}

	public int getExame() {
		return exame;
	}

	public void setExame(int exame) {
		this.exame = exame;
	}

	public int getRemedio() {
		return remedio;
	}

	public void setRemedio(int remedio) {
		this.remedio = remedio;
	}

	public int getTempoTratamento() {
		return duracaoDiasTratamento;
	}

	public void setTempoTratamento(int tempoTratamento) {
		this.duracaoDiasTratamento = tempoTratamento;
	}
	
}