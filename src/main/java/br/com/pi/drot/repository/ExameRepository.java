package br.com.pi.drot.repository;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ExameDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Exame;

public class ExameRepository extends GenericDAO<ExameRepository> implements ExameDAO{

	private Connection connection;


	public ExameRepository(){
		super(Exame.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarExame(String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(nomeExame);
		this.getConnection().getEntityManager().persist(diagnosticoExame);
		this.getConnection().getEntityManager().persist(descricaoExame);
		this.getConnection().getEntityManager().persist(dataExame);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo exame cadastrado com sucesso!" +this.getId());
		return true;
	}

	@Override
	public boolean listarExamePorId(int id) {
		this.getConnection().getEntityManager().clear();

		ExameRepository exame = this.getConnection().getEntityManager().find(ExameRepository.class, id);

		if(exame == null){
			System.out.println("Exame não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return true;
	}

	@Override
	public ArrayList<Exame> listarExame() {
		this.getConnection().getEntityManager();
		ArrayList<Exame> exame = (ArrayList<Exame>) this.getConnection().getEntityManager().createQuery("from Exame", Exame.class).getResultList();
		if(exame == null) {
			System.out.println("Não há exames cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return exame;
	}
	@Override
	public boolean removerExamePorId(int id) {
		ExameRepository exame = this.getConnection().getEntityManager().find(ExameRepository.class, id);

		if(exame == null){
			System.out.println("Exame não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Exame removido do banco com sucesso");

		return true;
	}

}
