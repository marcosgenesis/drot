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
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "RG")
	private String RG;

	@Column(name = "Data_nascimento")
	private Date dataNascimento;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "restricaoMedicamental")
	private  String restricaoMedicamental;

	@Column(name = "doencaHereditaria")
	private String doencaHereditaria;

	@Column(name = "tratamento")
	private ArrayList<TratamentoPaciente> tratamentos;

	public Paciente() {}

	public ArrayList<TratamentoPaciente> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(ArrayList<TratamentoPaciente> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public Paciente(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String restricaoMedicamental, String doencaHereditaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.restricaoMedicamental = restricaoMedicamental;
		this.doencaHereditaria = doencaHereditaria;
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

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		this.RG = rG;
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

	public boolean login() {
		return false;
	}

	public boolean logout() {
		return false;
	}

	public void preencherDadosRegistros(String restricaoMedicamental, String doencaHereditaria) {}

}
