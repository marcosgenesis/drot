package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ExameDAO;
import br.com.pi.drot.entity.Exame;

public class ExameRepository implements ExameDAO{

	private Connection connection;

	public ExameRepository(){
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Exame criarExame(String nomeExame, String diagnosticoExame, String descricaoExame, String dataExame) {
		Exame exame = new Exame();
		exame.setNomeExame(nomeExame);
		exame.setDiagnosticoExame(diagnosticoExame);
		exame.setDescricaoExame(descricaoExame);
		exame.setDataExame(dataExame);

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(exame);
		this.getConnection().getEntityManager().getTransaction().commit();
		System.out.println("Novo exame cadastrado com sucesso!" +exame.getId());

		return exame;
	}

	public int getIdByName(String nome) {
		try {
			Exame exame = this.getConnection().getEntityManager().createNamedQuery("Exame.getIdByName", Exame.class).setParameter("nome", nome).getSingleResult();

			System.out.println("=> E" + exame.getId());

			return exame.getId();
		} catch (NoResultException e) {
			return -1;
		}
	}
}
