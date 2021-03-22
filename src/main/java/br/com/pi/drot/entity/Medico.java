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

	public Medico(int id, String nome, String cPF, String rG, Date dataNascimento, String endereco, String telefone,
			boolean isAdmin, String cRM, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		RG = rG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.isAdmin = isAdmin;
		CRM = cRM;
		this.especialidade = especialidade;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String CRM) {
		CRM = CRM;
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
