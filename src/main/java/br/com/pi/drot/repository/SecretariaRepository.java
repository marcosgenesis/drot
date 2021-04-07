package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.SecretariaDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;
import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.utils.DataDoDia;

public class SecretariaRepository implements SecretariaDAO{
	Connection connection = Connection.getInstance();

	public SecretariaRepository() {}

	public boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.connection.getEntityManager().clear();

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
			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().persist(secretaria);
			this.connection.getEntityManager().getTransaction().commit();

			System.out.println("Nova(o) secretaria(o) cadastrado com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao criar secretaria.");
			return false;
		}
	}

	public Secretaria buscarSecretariaPorID(int id) {
		this.connection.getEntityManager().clear();

		try{
			Secretaria secretaria = this.connection.getEntityManager().createNamedQuery("Secretaria.getById", Secretaria.class).setParameter(id, id).getSingleResult();

			return secretaria;
		} catch(NoResultException ex) {
			System.out.println("Secretária não encontrada");
			return null;
		}
	}

	public ArrayList<Secretaria> listarSecretariasCadastrados() {
		this.connection.getEntityManager().clear();
		try {
			ArrayList<Secretaria> secretarias = (ArrayList<Secretaria>) this.connection.getEntityManager().createQuery("from Secretaria", Secretaria.class).getResultList();

			return secretarias;
		}catch(NoResultException ex) {
			System.out.println("Não há secretaria cadastradas em nosso banco de dados.");
			return null;
		}
	}

	public boolean removerSecretaria(int idSecretaria) {
		this.connection.getEntityManager().clear();
		Secretaria secretaria = this.buscarSecretariaPorID(idSecretaria);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
			return false;
		}

		try{
		 	this.connection.getEntityManager().getTransaction().begin();
	        this.connection.getEntityManager().remove(secretaria);
	        this.connection.getEntityManager().getTransaction().commit();

			System.out.println("Secretária removida do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover secretária.");
			return false;
		}
	}

	public ArrayList<ConsultasDoDia> consultasDoDia(int idPaciente, String dataDoDia) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
		TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataConsulta", dataDoDia);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();

		ArrayList<ConsultasDoDia> consultasDoDia = new ArrayList<ConsultasDoDia>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasDoDia.add(new ConsultasDoDia(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia(), consultas.size()));
		}

		for (int i = 0; i < consultasDoDia.size(); i++) {
			System.out.println(consultasDoDia.get(i));
		}

		return consultasDoDia;
	}

	public String pegarnomeSecretariaLogada(int idSecretaria) {
		String sqlConsulta = "SELECT s FROM Secretaria s WHERE s.id =: id";
		TypedQuery<Secretaria> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Secretaria.class).setParameter("id", idSecretaria);
		String nomeSecretariaLogada = queryConsultas.getSingleResult().getNome();
		return nomeSecretariaLogada;
	}

	public boolean logado(String email, String pass) {
		try {
			this.connection.getEntityManager().createNamedQuery("Secretaria.loginSecretaria", Secretaria.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
