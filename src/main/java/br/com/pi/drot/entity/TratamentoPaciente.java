package br.com.pi.drot.entity;

import java.sql.Date;
import java.util.ArrayList;

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

	@Column(name = "exame")
	private ArrayList <Exame> exame;

	@Column(name = "remedio")
	private ArrayList <Remedio> remedio;

	@Column(name = "tempoTratamento")
	private Date tempoTratamento;

	public TratamentoPaciente(){}

	public TratamentoPaciente(int id, ArrayList<Exame> exame, ArrayList<Remedio> remedio, Date tempoTratamento) {
		super();
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

	public ArrayList<Exame> getExame() {
		return exame;
	}

	public void setExame(ArrayList<Exame> exame) {
		this.exame = exame;
	}

	public ArrayList<Remedio> getRemedio() {
		return remedio;
	}

	public void setRemedio(ArrayList<Remedio> remedio) {
		this.remedio = remedio;
	}

	public Date getTempoTratamento() {
		return tempoTratamento;
	}

	public void setTempoTratamento(Date tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}

}