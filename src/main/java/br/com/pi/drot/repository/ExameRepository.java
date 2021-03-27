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

	public boolean cadastrarExame(String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
		Exame exame = new Exame();
		exame.setNomeExame(nomeExame);
		exame.setDiagnosticoExame(diagnosticoExame);
		exame.setDescricaoExame(descricaoExame);
		exame.setDataExame(dataExame);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(exame);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo exame cadastrado com sucesso!" +exame.getId());
		return true;
	}

	public Exame buscarExamePorId(int id) {
		this.getConnection().getEntityManager().clear();

		Exame exame = this.getConnection().getEntityManager().find(Exame.class, id);

		if(exame == null){
			System.out.println("Exame não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return exame;
	}


	public ArrayList<Exame> listarExames() {
		this.getConnection().getEntityManager();
		ArrayList<Exame> exames = (ArrayList<Exame>) this.getConnection().getEntityManager().createQuery("from Exame", Exame.class).getResultList();
		if(exames == null) {
			System.out.println("Não há exames cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return exames;
	}

	public boolean editarExame(Exame exame, String nomeExame, String diagnosticoExame, String descricaoExame,
			Date dataExame) {

		exame.setNomeExame(nomeExame);
		exame.setDiagnosticoExame(diagnosticoExame);
		exame.setDescricaoExame(descricaoExame);
		exame.setDataExame(dataExame);

		 try {
				this.getConnection().getEntityManager().getTransaction().begin();
				this.getConnection().getEntityManager().merge(exame);
				this.getConnection().getEntityManager().getTransaction().commit();
				this.getConnection().getEntityManager().close();
	        } catch (Exception ex) {
	    		System.out.println("Erro ao editar exame.");
	            return false;
	        }
			System.out.println("Exame editado com sucesso!");
	        return true;
	}


	public boolean removerExamePorId(int id) {
		Exame exame = this.getConnection().getEntityManager().find(Exame.class, id);

		if(exame == null){
			System.out.println("Exame não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Exame removido do banco com sucesso");

		return true;
	}


}
