package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

public class AdministradorModel{
	private int id;
	private String nome;
	private String CPF;
	private String RG;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;

	public AdministradorModel() {}

	public AdministradorModel(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone,
			String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
