package br.com.pi.drot.repository;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.RemedioDAO;
import br.com.pi.drot.entity.Remedio;

public class RemedioRepository extends GenericDAO<RemedioRepository> implements RemedioDAO{
	private Connection connection;

	public RemedioRepository() {
		super(Remedio.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
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
		this.getConnection().getEntityManager().close();
		System.out.println("Novo remédio cadastrado com sucesso!" +remedio.getId());
		return remedio;
	}
}
