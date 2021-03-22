package br.com.pi.drot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exame")
public class ExameModel {
	private int id;
	private String nomeExame;
	private String diagnosticoExame;
	private String descricaoExame;
	private Date dataExame;


	public ExameModel(){}

	public ExameModel(int id, String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
		super();
		this.id = id;
		this.nomeExame = nomeExame;
		this.diagnosticoExame = diagnosticoExame;
		this.descricaoExame = descricaoExame;
		this.dataExame = dataExame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getDiagnosticoExame() {
		return diagnosticoExame;
	}

	public void setDiagnosticoExame(String diagnosticoExame) {
		this.diagnosticoExame = diagnosticoExame;
	}

	public String getDescricaoExame() {
		return descricaoExame;
	}

	public void setDescricaoExame(String descricaoExame) {
		this.descricaoExame = descricaoExame;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

}
