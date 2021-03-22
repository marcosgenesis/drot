package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public abstract class Medico{
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

	@Column(name = "is_admin")
	private boolean isAdmin;

	@Column(name = "CRM")
	private String CRM;

	@Column(name = "especialidade")
	private String especialidade;

	public Medico(){}

	public Medico(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone,
			boolean isAdmin, String cRM, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.isAdmin = isAdmin;
		CRM = cRM;
		this.especialidade = especialidade;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void consultarPaciente() {}
	public void editarHistoricoPaciente() {}
	public void consultarHistoricoPaciente() {}
	public void criarTratamentodoPaciente() {}
	public void editarTratamentodoPaciente() {}

}
