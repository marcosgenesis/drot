package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.entity.Medico;

public class MedicoRepository implements MedicoDAO{
	Connection connection = Connection.getInstance();

	public MedicoRepository() {}

	public boolean cadastrarNovoMedico(String nome, String CPF, String RG, String dataNascimento, int i, String telefone, String email, String senha) {
		this.connection.getEntityManager().clear();
		Medico medico = new Medico();
		medico.setNome(nome);
		medico.setCPF(CPF);
		medico.setRG(RG);
		medico.setDataNascimento(dataNascimento);
		medico.setEndereco(i);
		medico.setTelefone(telefone);
		medico.setEmail(email);
		medico.setSenha(senha);
		try {
			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().persist(medico);
			this.connection.getEntityManager().getTransaction().commit();

			System.out.println("Nova(o) medico(a) cadastrado com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao criar médico.");
			return false;
		}
	}

	public Medico buscarMedicoPorID(int id) {
		this.connection.getEntityManager().clear();

		try{
			Medico medico = this.connection.getEntityManager().createNamedQuery("Medico.getById", Medico.class).setParameter(id, id).getSingleResult();

			return medico;
		} catch(NoResultException ex) {
			System.out.println("Médico não encontrado");
			return null;
		}
	}

	public int buscarIdMedicoPorCPF(String cpf) {
		this.connection.getEntityManager().clear();

		try {
			Medico medico = this.connection.getEntityManager().createNamedQuery("Medico.getIdByCpf", Medico.class).setParameter("cpf", cpf).getSingleResult();
			return medico.getId();
		} catch (NoResultException ex) {
			return -1;
		}
	}

	public ArrayList<Medico> listarMedicosCadastrados() {
		this.connection.getEntityManager().clear();
		this.connection.getEntityManager();

		try {
			ArrayList<Medico> medicos = (ArrayList<Medico>) this.connection.getEntityManager().createQuery("from Medico", Medico.class).getResultList();

			return medicos;
		}catch(NoResultException ex) {
			System.out.println("Não há médicos cadastrados em nosso banco de dados.");
			return null;
		}
	}

	public boolean removerMedico(int idMedico) {
		this.connection.getEntityManager().clear();

		Medico medico = this.buscarMedicoPorID(idMedico);

		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

		try{
		 	this.connection.getEntityManager().getTransaction().begin();
	        this.connection.getEntityManager().remove(medico);
	        this.connection.getEntityManager().getTransaction().commit();

			System.out.println("Médico removido do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover médico.");
			return false;
		}
	}

	public String pegarNomeMedicoLogado(int idMedico) {
		String sqlConsulta = "SELECT m FROM Medico m WHERE m.id =: id";
		TypedQuery<Medico> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Medico.class).setParameter("id", idMedico);
		String nomeMedicoLogado = queryConsultas.getSingleResult().getNome();
		return nomeMedicoLogado;
	}



	public boolean logado(String email, String pass) {
		try {
			this.connection.getEntityManager().createNamedQuery("Medico.loginMedico", Medico.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}


