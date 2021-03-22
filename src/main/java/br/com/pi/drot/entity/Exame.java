package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exame")
public class Exame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nomeExame")
	private String nomeExame;

	@Column(name = "diagnosticoExame")
	private String diagnosticoExame;

	@Column(name = "descricaoExame")
	private String descricaoExame;

	@Column(name = "dataExame")
	private Date dataExame;

	public Exame(){}

	public Exame(int id, String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
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
