package br.com.pi.drot.model;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Paciente;

public class PacienteModel extends GenericDAO<PacienteModel>{
	private int id;
	private String nome;
	private String CPF;
	private String RG;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	private String restricaoMedicamental;
	private String doencaHereditaria;
	private Connection connection;

	public PacienteModel() {
		super(Paciente.class);
		this.connection = new Connection();
	}

	public PacienteModel(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone,
			boolean isAdmin, String restricaoMedicamental, String doencaHereditaria) {
		super(Paciente.class);
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

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
