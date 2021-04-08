package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.entity.Administrador;

public class AdministradorRepository implements AdministradorDAO{
	Connection connection = Connection.getInstance();

	public AdministradorRepository() {}

	public boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.connection.getEntityManager().clear();
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
			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().persist(administrador);
			this.connection.getEntityManager().getTransaction().commit();

		} catch(Exception ex) {
			System.out.println("Erro ao criar administrador.");
            return false;
		}

		System.out.println("Novo administrador cadastrado com sucesso!");
		return true;
	}

	public Administrador buscarAdministradorPorID(int id) {
		this.connection.getEntityManager().clear();
		try{
			Administrador administrador = this.connection.getEntityManager().createNamedQuery("Administrador.getById", Administrador.class).setParameter(id, id).getSingleResult();

			return administrador;
		} catch(NoResultException ex) {
			System.out.println("Administrador não encontrado");
			return null;
		}
	}

	public boolean logado(String email, String pass) {
		try {
			this.connection.getEntityManager().createNamedQuery("Administrador.loginAdm", Administrador.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
