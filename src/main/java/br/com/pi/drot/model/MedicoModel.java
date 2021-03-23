package br.com.pi.drot.model;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class MedicoModel extends GenericDAO<MedicoModel> implements MedicoDAO {
	private int id;
	private String nome;
	private String CPF;
	private String RG;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	private String CRM;
	private String especialidade;
	private Connection connection;


	public MedicoModel(NameDataBaseConnection nameDataBaseConnection) {
		super(Medico.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public MedicoModel(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone,
			String email, String senha, String CRM, String especialidade) {
		super(Medico.class);
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.CRM = CRM;
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

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	@Override
	public void consultarPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarHistoricoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarHistoricoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void criarTratamentodoPaciente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarTratamentodoPaciente() {
		// TODO Auto-generated method stub

	}


}


