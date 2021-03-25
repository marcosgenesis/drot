package br.com.pi.drot.model;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Consulta;

public class ConsultaRepository extends GenericDAO<ConsultaRepository> implements ConsultaDAO {

	private Connection connection;

	public ConsultaRepository(){
        super(Consulta.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarConsulta(Paciente paciente, MedicoRepository medico, Date dataConsulta) {

		Consulta c = new Consulta();

		c.setPaciente(1);
		c.setMedico(1);
		c.setDataConsulta(dataConsulta);

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(c);
		this.getConnection().getEntityManager().getTransaction().commit();

		this.getConnection().getEntityManager().close();

		System.out.println("Nova consulta cadastrada com sucesso! Com o id: " + this.getId());

		return true;
	}

	@Override
	public boolean remarcarConsulta(PacienteRepository paciente, MedicoRepository medico, Date dataConsulta) {
		if(paciente == null){
			System.out.println("Paciente não encontrado para remarcar consulta");
			return false;
		}

		System.out.println("Digite o id da consulta");

		ConsultaRepository procurarConsulta = this.getConnection().getEntityManager().find(ConsultaRepository.class, id);

		if(procurarConsulta == null){
			System.out.println("Consulta não cadastrada para remarcar");
			return false;
		}

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(medico);
            this.getConnection().getEntityManager().merge(dataConsulta);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro remarcar consulta");
            return false;
        }

		System.out.println("Consulta editada sucesso!");

        return true;
	}

	@Override
	public boolean desmarcarConsulta(PacienteRepository paciente, MedicoRepository medico, Date dataConsulta) {
		if(paciente == null){
			System.out.println("Paciente não encontrado para desmarcar consulta");
			return false;
		}

	 	this.getConnection().getEntityManager().getTransaction().begin();
        this.getConnection().getEntityManager().remove(this.getId());
        this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Consulta" + this.getId() + "desmarcada do banco com sucesso!");

		return true;
	}

	@Override
	public boolean buscarConsultaPorId(int id) {
		this.getConnection().getEntityManager().clear();

		ConsultaRepository consulta = this.getConnection().getEntityManager().find(ConsultaRepository.class, id);

		if(consulta == null){
			System.out.println("Consulta não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return true;
	}

}

