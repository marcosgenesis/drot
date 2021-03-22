package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;


public class TratamentoPacienteModel{

	private int id;
	private ArrayList<ExameModel> exame;
	private ArrayList<RemedioModel> remedio;
	private Date tempoTratamento;
	public TratamentoPacienteModel(){}

	public TratamentoPacienteModel(int id, ArrayList<ExameModel> exame, ArrayList<RemedioModel> remedio, Date tempoTratamento) {
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

}