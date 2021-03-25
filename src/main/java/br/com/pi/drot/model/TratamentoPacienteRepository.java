package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.TratamentoPaciente;

public class TratamentoPacienteRepository extends GenericDAO<TratamentoPacienteRepository> implements TratamentoPacienteDAO{
	private Connection connection;

	public TratamentoPacienteRepository(){
		super(TratamentoPaciente.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarTratamento(PacienteRepository paciente, TratamentoPacienteRepository tratamento) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(paciente);
		this.getConnection().getEntityManager().persist(tratamento);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo tratamento cadastrado com sucesso!" +this.getId());
		return true;
	}

	@Override
	public TratamentoPacienteRepository buscarTratamentoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		TratamentoPacienteRepository tratamento = this.getConnection().getEntityManager().find(TratamentoPacienteRepository.class, id);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return tratamento;
	}

	@Override
	public ArrayList<TratamentoPacienteRepository> listarTratamento() {
		this.getConnection().getEntityManager();
		ArrayList<TratamentoPacienteRepository> tratamentos = (ArrayList<TratamentoPacienteRepository>) this.getConnection().getEntityManager().createQuery("from TratamentoPaciente", TratamentoPacienteRepository.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return tratamentos;
	}

	@Override
	public boolean editar(PacienteRepository paciente, TratamentoPacienteRepository tratamento) {
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
		TratamentoPacienteRepository tratamento = this.getConnection().getEntityManager().find(TratamentoPacienteRepository.class, id);

		if(tratamento == null){
			System.out.println("Tratamento para paciente não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Tratamento removido do banco com sucesso");

		return true;
	}

}