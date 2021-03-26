package br.com.pi.drot.repository;

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

	public boolean criarTratamento(Paciente paciente, Remedio remedio, Exame exame) {
		TratamentoPaciente tratamento = new TratamentoPaciente();
		tratamento.adicionarExame(tratamento, exame);
		tratamento.adicionarRemedio(tratamento, remedio);
		tratamento.setPaciente(paciente.getId());

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(tratamento);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo tratamento cadastrado com sucesso!" +tratamento.getId());
		return true;
	}

	public TratamentoPaciente buscarTratamentoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		TratamentoPaciente tratamento = this.getConnection().getEntityManager().find(TratamentoPaciente.class, id);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return tratamento;
	}

	public ArrayList<TratamentoPaciente> listarTratamento() {
		this.getConnection().getEntityManager();
		ArrayList<TratamentoPaciente> tratamentos = (ArrayList<TratamentoPaciente>) this.getConnection().getEntityManager().createQuery("from TratamentoPaciente", TratamentoPaciente.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return tratamentos;
	}

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