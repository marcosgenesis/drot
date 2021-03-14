package br.com.pi.drot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "CPF")
	private int CPF;

	@Column(name = "RG")
	private int RG;

	@Column(name = "Data_nascimento")
	private Date data_nascimento;

	@Column(name = "is_admin")
	private boolean isAdmin;


	public Usuario() {}

	public Usuario(int id, String nome, int cPF, int rG, Date data_nascimento, boolean isAdmin) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		RG = rG;
		this.data_nascimento = data_nascimento;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public int getRG() {
		return RG;
	}

	public void setRG(int rG) {
		RG = rG;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void isAdmin(boolean is_admin) {
		this.isAdmin = is_admin;
	}

	public boolean login() {
		return false;
	}

	public boolean logout() {
		return false;
	}

}
