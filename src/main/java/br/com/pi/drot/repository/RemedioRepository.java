package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.RemedioDAO;
import br.com.pi.drot.entity.Remedio;

public class RemedioRepository implements RemedioDAO{
	Connection connection = Connection.getConnection();

	public RemedioRepository() {}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conexao) {
		this.connection = Connection.getConnection();
		this.connection = conexao;
	}

	public Remedio criarRemedio(String nomeRemedio, String dosagem, String bula, String contraIndicacao) {
		Remedio remedio = new Remedio();
		remedio.setNomeRemedio(nomeRemedio);
		remedio.setDosagem(dosagem);
		remedio.setBula(bula);
		remedio.setContraIndicacao(contraIndicacao);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(remedio);
		this.getConnection().getEntityManager().getTransaction().commit();
		System.out.println("Novo remédio cadastrado com sucesso!" + remedio.getId());

		return remedio;
	}

	public int buscarIdByNome(String nome) {
		try {
			Remedio remedio = this.getConnection().getEntityManager().createNamedQuery("Remedio.getIdByName", Remedio.class).setParameter("nome", nome).getSingleResult();

			System.out.println("=> R" + remedio.getId());

			return remedio.getId();
		} catch(NoResultException e) {
			return -1;
		}
	}
}
