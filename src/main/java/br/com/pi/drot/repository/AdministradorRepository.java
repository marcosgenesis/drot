package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

public class AdministradorRepository implements AdministradorDAO{
	Connection connection = Connection.getConnection();

	public AdministradorRepository() {}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conexao) {
		this.connection = Connection.getConnection();
		this.connection = conexao;
	}

	public boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();
		Administrador administrador = new Administrador();
		administrador.setNome(nome);
		administrador.setCPF(CPF);
		administrador.setRG(RG);
		administrador.setDataNascimento(dataNascimento);
		administrador.setEndereco(endereco);
		administrador.setTelefone(telefone);
		administrador.setEmail(email);
		administrador.setSenha(senha);

		try{
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(administrador);
			this.getConnection().getEntityManager().getTransaction().commit();

		} catch(Exception ex) {
			System.out.println("Erro ao criar administrador.");
            return false;
		}

		System.out.println("Novo administrador cadastrado com sucesso!");
		return true;
	}

	public Administrador buscarAdministradorPorID(int id) {
		this.getConnection().getEntityManager().clear();
		try{
			Administrador administrador = this.getConnection().getEntityManager().createNamedQuery("Administrador.getById", Administrador.class).setParameter(id, id).getSingleResult();

			return administrador;
		} catch(NoResultException ex) {
			System.out.println("Administrador não encontrado");
			return null;
		}
	}


	public boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();

		Secretaria secretaria = new Secretaria();
		secretaria.setNome(nome);
		secretaria.setCPF(CPF);
		secretaria.setRG(RG);
		secretaria.setDataNascimento(dataNascimento);
		secretaria.setEndereco(endereco);
		secretaria.setTelefone(telefone);
		secretaria.setEmail(email);
		secretaria.setSenha(senha);

		try {
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(secretaria);
			this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Nova(o) secretaria(o) cadastrado com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao criar secretaria.");
			return false;
		}
	}

	public Secretaria buscarSecretariaPorID(int id) {
		this.getConnection().getEntityManager().clear();

		try{
			Secretaria secretaria = this.getConnection().getEntityManager().createNamedQuery("Secretaria.getById", Secretaria.class).setParameter(id, id).getSingleResult();

			return secretaria;
		} catch(NoResultException ex) {
			System.out.println("Secretária não encontrada");
			return null;
		}
	}

	public ArrayList<Secretaria> listarSecretariasCadastrados() {
		this.getConnection().getEntityManager().clear();
		try {
			ArrayList<Secretaria> secretarias = (ArrayList<Secretaria>) this.getConnection().getEntityManager().createQuery("from Secretaria", Secretaria.class).getResultList();

			return secretarias;
		}catch(NoResultException ex) {
			System.out.println("Não há secretaria cadastradas em nosso banco de dados.");
			return null;
		}
	}

	public boolean removerSecretaria(int idSecretaria) {
		this.getConnection().getEntityManager().clear();
		Secretaria secretaria = this.buscarSecretariaPorID(idSecretaria);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
			return false;
		}

		try{
		 	this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(secretaria);
	        this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Secretária removida do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover secretária.");
			return false;
		}
	}

	public boolean logado(String email, String pass) {
		try {
			Administrador a = this.getConnection().getEntityManager().createNamedQuery("Administrador.loginAdm", Administrador.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public String buscarNomeSecretariaPorID(int idSecretaria) {
		// TODO Auto-generated method stub
		return null;
	}
}
