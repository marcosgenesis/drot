package br.com.pi.drot.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "Paciente.getIdByCpf", query = "SELECT p FROM Paciente p WHERE p.CPF = :cpf")
@NamedQuery(name = "Paciente.getById", query = "SELECT p FROM Paciente p WHERE p.id =: idP")
@Entity
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codpac")
	private int id;

	@Column(name = "nome_paciente")
	private String nome;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "RG")
	private String RG;

	@Column(name = "DataNascimento")
	private String dataNascimento;

	@Column(name = "cod_endereco")
	private int endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "restricaoMedicamental")
	private  String restricaoMedicamental;

	@Column(name = "doencaHereditaria")
	private String doencaHereditaria;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

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

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRestricaoMedicamental() {
		return restricaoMedicamental;
	}

	public void setRestricaoMedicamental(String restricaoMedicamental) {
		this.restricaoMedicamental = restricaoMedicamental;
	}

	public String getDoencaHereditaria() {
		return doencaHereditaria;
	}

	public void setDoencaHereditaria(String doencaHereditaria) {
		this.doencaHereditaria = doencaHereditaria;
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
