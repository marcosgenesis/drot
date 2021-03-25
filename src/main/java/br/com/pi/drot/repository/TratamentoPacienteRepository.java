package br.com.pi.drot.repository;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Remedio;
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
	public boolean cadastrarTratamento(Paciente paciente) {
		TratamentoPaciente tratamento = new TratamentoPaciente();
		tratamento.setPaciente(paciente.getId());
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(tratamento);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo tratamento cadastrado com sucesso!" +this.getId());
		return true;


		tratamento.setPaciente(paciente.getId());
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
	public TratamentoPaciente buscarTratamentoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		TratamentoPaciente tratamento = this.getConnection().getEntityManager().find(TratamentoPaciente.class, id);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return tratamento;
	}

	@Override
	public ArrayList<TratamentoPaciente> listarTratamento() {
		this.getConnection().getEntityManager();
		ArrayList<TratamentoPacientes> tratamentos = (ArrayList<TratamentoPacienteRepository>) this.getConnection().getEntityManager().createQuery("from TratamentoPaciente", TratamentoPacienteRepository.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return tratamentos;
	}

	@Override
	public boolean editarTratamentoPaciente(Paciente paciente, TratamentoPaciente tratamento) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
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