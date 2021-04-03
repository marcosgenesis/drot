package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.entity.Consulta;

public class ConsultaRepository implements ConsultaDAO {

	private Connection connection;
	public ConsultaRepository(){
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean criarConsulta(int paciente, int medico, String dataConsulta, String descricao, String classificacaoUrgencia, boolean consultaRealizada, String andamentoConsulta, String consultorioConsulta) {
		Consulta consulta = new Consulta();
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		consulta.setDescricaoConsulta(descricao);
		consulta.setDataConsulta(dataConsulta);
		consulta.setClassificacaoUrgencia(classificacaoUrgencia);
		consulta.setAndamentoConsulta(andamentoConsulta);
		consulta.setConsultorioConsulta(consultorioConsulta);
		consulta.setConsultaRealizada(false);

		try {
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(consulta);
			this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Nova consulta cadastrada com sucesso! Com o id: " + consulta.getId());
			return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao remarcar consulta");
            return false;
        }
	}


	public boolean remarcarConsulta(int idConsulta, String dataConsulta) {
		this.getConnection().getEntityManager().clear();
		Consulta consulta = this.buscarConsultaPorId(idConsulta);
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}

		consulta.setDataConsulta(dataConsulta);
		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(consulta);
            this.getConnection().getEntityManager().getTransaction().commit();

    		System.out.println("Consulta remarcada com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao remarcar consulta");
            return false;
        }
	}

	public boolean desmarcarConsulta(int idConsulta) {
		this.getConnection().getEntityManager().clear();
		Consulta consulta = this.buscarConsultaPorId(idConsulta);
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}
		try {
		 	this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(consulta);
	        this.getConnection().getEntityManager().getTransaction().commit();
			System.out.println("Consulta" + consulta.getId() + "desmarcada do banco com sucesso!");
			return true;
		}catch(Exception ex) {
			System.out.println("Erro ao remarcar consulta");
            return false;
		}
	}

	public Consulta buscarConsultaPorId(int id) {
		this.getConnection().getEntityManager().clear();

		try{
			Consulta consulta = this.getConnection().getEntityManager().createNamedQuery("Consulta.getById", Consulta.class).setParameter(id, id).getSingleResult();
			return consulta;
		} catch(NoResultException ex) {
			System.out.println("Consulta não encontrada");
			return null;
		}
	}

	public boolean marcarConsultaComoConcluida(int idConsulta){
		this.getConnection().getEntityManager().clear();
		try{
			Consulta consulta = buscarConsultaPorId(idConsulta);
			consulta.setConsultaRealizada(true);
			try{
				this.getConnection().getEntityManager().getTransaction().begin();
		        this.getConnection().getEntityManager().merge(consulta);
		        this.getConnection().getEntityManager().getTransaction().commit();

				System.out.println("A Consulta foi concluída com sucesso.");
				return true;
			}catch(Exception ex) {
				System.out.println("Erro na realização da consulta");
	            return false;
			}
		}catch(NoResultException ex) {
			System.out.println("Consulta não encontrada");
			return false;
		}
	}

	public boolean editarAndamentoConsulta(int idConsulta, String andamentoConsulta) {
		this.getConnection().getEntityManager().clear();
		Consulta consulta = this.buscarConsultaPorId(idConsulta);
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}

		consulta.setDataConsulta(andamentoConsulta);
		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(consulta);
            this.getConnection().getEntityManager().getTransaction().commit();

    		System.out.println("Consulta editada com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao editar consulta");
            return false;
        }
	}

	public boolean editarUrgenciaDaConsulta(int idConsulta, String classificacaoUrgencia) {
		this.getConnection().getEntityManager().clear();
		Consulta consulta = this.buscarConsultaPorId(idConsulta);
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}
		consulta.setDataConsulta(classificacaoUrgencia);
		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(consulta);
            this.getConnection().getEntityManager().getTransaction().commit();

    		System.out.println("Consulta editada com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao editar consulta");
            return false;
        }
	}
}

