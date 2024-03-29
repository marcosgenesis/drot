package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Remedio.getIdByName", query = "SELECT r FROM Remedio r WHERE r.nomeRemedio =: nome"),
	@NamedQuery(name = "Remedio.getById", query = "SELECT r FROM Remedio r WHERE r.id =: idR")
})

@Entity
@Table(name = "Remedio")
public class Remedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codremedio")
	private int id;

	@Column(name = "nomeRemedio")
	private String nomeRemedio;

	@Column(name = "dosagem")
	private String dosagem;

	@Column(name = "bula")
	private String bula;

	@Column(name = "contraIndicacao")
	private String contraIndicacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}

}
