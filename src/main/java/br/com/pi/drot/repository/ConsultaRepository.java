package br.com.pi.drot.repository;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;

public class ConsultaRepository extends GenericDAO<Consulta> implements ConsultaDAO {

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
	public boolean criarConsulta(Paciente paciente, Medico medico, Date dataConsulta) {
		Consulta consulta = new Consulta();
		consulta.setPaciente(paciente.getId());
		consulta.setMedico(medico.getId());
		consulta.setDataConsulta(dataConsulta);

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(consulta);
		this.getConnection().getEntityManager().getTransaction().commit();

		this.getConnection().getEntityManager().close();

		System.out.println("Nova consulta cadastrada com sucesso! Com o id: " + consulta.getId());

		return true;
	}

	@Override
	public boolean remarcarConsulta(Consulta consulta, Date dataConsulta) {
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}

		consulta.setDataConsulta(dataConsulta);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(consulta);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao remarcar consulta");
            return false;
        }

		System.out.println("Consulta remarcada com sucesso!");

        return true;
	}

	@Override
	public boolean desmarcarConsulta(Consulta consulta) {
		if(consulta == null){
			System.out.println("Consulta não encontrada.");
			return false;
		}

	 	this.getConnection().getEntityManager().getTransaction().begin();
        this.getConnection().getEntityManager().remove(consulta.getId());
        this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Consulta" + consulta.getId() + "desmarcada do banco com sucesso!");

		return true;
	}

	@Override
	public Consulta buscarConsultaPorId(int id) {
		this.getConnection().getEntityManager().clear();

		Consulta consulta = this.getConnection().getEntityManager().find(Consulta.class, id);

		if(consulta == null){
			System.out.println("Consulta não encontrada.");
		}

		this.getConnection().getEntityManager().close();
		return consulta;
	}

}

