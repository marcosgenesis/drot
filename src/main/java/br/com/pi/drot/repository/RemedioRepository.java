package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.RemedioDAO;
import br.com.pi.drot.entity.Remedio;

public class RemedioRepository implements RemedioDAO{
	Connection connection = Connection.getInstance();

	public RemedioRepository() {}

	public Remedio criarRemedio(String nomeRemedio, String dosagem, String bula, String contraIndicacao) {
		Remedio remedio = new Remedio();
		remedio.setNomeRemedio(nomeRemedio);
		remedio.setDosagem(dosagem);
		remedio.setBula(bula);
		remedio.setContraIndicacao(contraIndicacao);
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(remedio);
		this.connection.getEntityManager().getTransaction().commit();
		System.out.println("Novo remédio cadastrado com sucesso!" + remedio.getId());

		return remedio;
	}

	public int buscarIdDoRemedioPeloNome(String nome) {
		try {
			Remedio remedio = this.connection.getEntityManager().createNamedQuery("Remedio.getIdByName", Remedio.class).setParameter("nome", nome).getSingleResult();

			System.out.println("=> R" + remedio.getId());

			return remedio.getId();
		} catch(NoResultException e) {
			return -1;
		}
	}

	public Remedio buscarRemedioPorID(int id) {
		this.connection.getEntityManager().clear();
		Remedio remedio = this.connection.getEntityManager().find(Remedio.class, id);
		if(remedio == null){
			System.out.println("Remedio não encontrado");
		}
		return remedio;
	}
}
