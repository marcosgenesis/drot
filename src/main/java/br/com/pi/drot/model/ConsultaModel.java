package br.com.pi.drot.model;

import java.sql.Date;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ConsultaDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Consulta;

public class ConsultaModel extends GenericDAO<ConsultaModel> implements ConsultaDAO {
	private int id;
	private PacienteModel paciente;
	private Date dataConsulta;
	private String descricaoConsulta;
	private MedicoModel medico;
	private Connection connection;

	public ConsultaModel(){
        super(Consulta.class);
		this.connection = new Connection();
	}

	public ConsultaModel(int id, PacienteModel paciente, Date dataConsulta, String descricaoConsulta, MedicoModel medico) {
		super(Consulta.class);
		this.id = id;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.descricaoConsulta = descricaoConsulta;
		this.medico = medico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PacienteModel getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteModel paciente) {
		this.paciente = paciente;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}

	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}

	public MedicoModel getMedico() {
		return medico;
	}

	public void setMedico(MedicoModel medico) {
		this.medico = medico;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta) {

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
	public boolean remarcarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta) {
		if(paciente == null){
			System.out.println("Paciente não encontrado para remarcar consulta");
			return false;
		}

		System.out.println("Digite o id da consulta");

		ConsultaModel procurarConsulta = this.getConnection().getEntityManager().find(ConsultaModel.class, id);

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
	public boolean desmarcarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta) {
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

		ConsultaModel consulta = this.getConnection().getEntityManager().find(ConsultaModel.class, id);

		if(consulta == null){
			System.out.println("Consulta não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return true;
	}

}

