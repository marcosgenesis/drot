package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TratamentoPaciente")
public class TratamentoPaciente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "paciente_id")
	private int paciente;

	@Column(name = "cod_exame")
	private int exame;

	@Column(name = "cod_remedio")
	private int remedio;

	@Column(name = "tempoTratamento")
	private int tempoTratamento;


	public int getId() {
		return id;
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
		return tempoTratamento;
	}

	public void setTempoTratamento(int tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}
}