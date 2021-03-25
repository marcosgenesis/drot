package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.TratamentoPaciente;

public class TratamentoPacienteModel extends GenericDAO<TratamentoPacienteModel> implements TratamentoPacienteDAO{

	private int id;
	private ArrayList<ExameModel> exame;
	private ArrayList<RemedioModel> remedio;
	private Date tempoTratamento;
	private Connection connection;

	public TratamentoPacienteModel(){
		super(TratamentoPaciente.class);
		this.connection = new Connection();

	}

	public TratamentoPacienteModel(int id, ArrayList<ExameModel> exame, ArrayList<RemedioModel> remedio, Date tempoTratamento) {
		super(TratamentoPaciente.class);
		this.id = id;
		this.exame = exame;
		this.remedio = remedio;
		this.tempoTratamento = tempoTratamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ExameModel> getExame() {
		return exame;
	}

	public void setExame(ArrayList<ExameModel> exame) {
		this.exame = exame;
	}

	public ArrayList<RemedioModel> getRemedio() {
		return remedio;
	}

	public void setRemedio(ArrayList<RemedioModel> remedio) {
		this.remedio = remedio;
	}

	public Date getTempoTratamento() {
		return tempoTratamento;
	}

	public void setTempoTratamento(Date tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarTratamento(PacienteModel paciente, TratamentoPacienteModel tratamento) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(paciente);
		this.getConnection().getEntityManager().persist(tratamento);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo tratamento cadastrado com sucesso!" +this.getId());
		return true;
	}

	@Override
	public TratamentoPacienteModel buscarTratamentoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		TratamentoPacienteModel tratamento = this.getConnection().getEntityManager().find(TratamentoPacienteModel.class, id);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return tratamento;
	}

	@Override
	public ArrayList<TratamentoPacienteModel> listarTratamento() {
		this.getConnection().getEntityManager();
		ArrayList<TratamentoPacienteModel> tratamentos = (ArrayList<TratamentoPacienteModel>) this.getConnection().getEntityManager().createQuery("from TratamentoPaciente", TratamentoPacienteModel.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return tratamentos;
	}

	@Override
	public boolean editar(PacienteModel paciente, TratamentoPacienteModel tratamento) {
		if(paciente == null){
			System.out.println("Paciente não encontrado para editar tratamento");
			return false;
		}

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(paciente);
            this.getConnection().getEntityManager().merge(tratamento.getRemedio());
            this.getConnection().getEntityManager().merge(tratamento.getTempoTratamento());
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro editar tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	@Override
	public boolean removerTratamentoPorId(int id) {
		TratamentoPacienteModel tratamento = this.getConnection().getEntityManager().find(TratamentoPacienteModel.class, id);

		if(tratamento == null){
			System.out.println("Tratamento para paciente não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Médico removido do banco com sucesso");

		return true;
	}

}