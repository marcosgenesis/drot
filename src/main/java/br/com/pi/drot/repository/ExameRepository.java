package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ExameDAO;
import br.com.pi.drot.entity.Exame;

public class ExameRepository implements ExameDAO{
	Connection connection = Connection.getInstance();


	public ExameRepository(){
	}


	public Exame criarExame(String nomeExame, String diagnosticoExame, String descricaoExame, String dataExame) {
		Exame exame = new Exame();
		exame.setNomeExame(nomeExame);
		exame.setDiagnosticoExame(diagnosticoExame);
		exame.setDescricaoExame(descricaoExame);
		exame.setDataExame(dataExame);

		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(exame);
		this.connection.getEntityManager().getTransaction().commit();
		System.out.println("Novo exame cadastrado com sucesso!" +exame.getId());

		return exame;
	}

	public Exame buscarExamePorID(int id) {
		this.connection.getEntityManager().clear();
		Exame exame = this.connection.getEntityManager().find(Exame.class, id);
		if(exame == null){
			System.out.println("Exame não encontrado");
		}
		return exame;
	}

	public int buscarIdExamePeloNome(String nome) {
		try {
			Exame exame = this.connection.getEntityManager().createNamedQuery("Exame.getIdByName", Exame.class).setParameter("nome", nome).getSingleResult();

			System.out.println("=> E" + exame.getId());

			return exame.getId();
		} catch (NoResultException e) {
			return -1;
		}
	}

}
