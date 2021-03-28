package br.com.pi.drot.repository;

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

	@Override
	public boolean criarConsulta(int paciente, int medico, String dataConsulta, String descricao) {
		Consulta consulta = new Consulta();
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		consulta.setDescricaoConsulta(descricao);
		consulta.setDataConsulta(dataConsulta);

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(consulta);
		this.getConnection().getEntityManager().getTransaction().commit();

		this.getConnection().getEntityManager().close();

		System.out.println("Nova consulta cadastrada com sucesso! Com o id: " + consulta.getId());

		return true;
	}

	@Override
	public boolean remarcarConsulta(Consulta consulta, String dataConsulta) {
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

