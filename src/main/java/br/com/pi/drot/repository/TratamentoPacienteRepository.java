package br.com.pi.drot.repository;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.Exame;
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

	public boolean criarTratamentoPaciente(int idPaciente, int tempoTratamento) {
		TratamentoPaciente tratamento = new TratamentoPaciente();
		tratamento.setPaciente(idPaciente);
		tratamento.setTempoTratamento(tempoTratamento);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(tratamento);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo tratamento cadastrado com sucesso!" +tratamento.getId());
		return true;
	}

	public TratamentoPaciente buscarTratamentoPacientePorID(int id) {
		this.getConnection().getEntityManager().clear();
		TratamentoPaciente tratamento = this.getConnection().getEntityManager().find(TratamentoPaciente.class, id);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return tratamento;
	}

	public ArrayList<TratamentoPaciente> listarTratamentosPaciente() {
		this.getConnection().getEntityManager();
		ArrayList<TratamentoPaciente> tratamentos = (ArrayList<TratamentoPaciente>) this.getConnection().getEntityManager().createQuery("from TratamentoPaciente", TratamentoPaciente.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return tratamentos;
	}

	public boolean editarTratamentoPacienteAdicionarRemedio(int idTratamento, int idRemedio) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		Remedio remedio = buscarRemedioPorID(idRemedio);

		this.adicionarRemedio(remedio, idTratamento);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao adicionar remedio ao tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean editarTratamentoPacienteAdicionarExame(int idTratamento, int idExame) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		Exame exame = buscarExamePorID(idExame);

		this.adicionarExame(exame, idTratamento);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao adicionar remedio ao tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean editarTratamentoPacienteAlterarTempoTratamento(int idTratamento, int tempoTratamento) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);

		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.setTempoTratamento(tempoTratamento);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro editar a data final de tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean removerTratamentoPacientePorId(int id) {
		TratamentoPaciente tratamento = this.getConnection().getEntityManager().find(TratamentoPaciente.class, id);

		if(tratamento == null){
			System.out.println("Tratamento para paciente não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Tratamento removido do banco com sucesso");

		return true;
	}

	public boolean adicionarRemedio(int remedio, int idTratamento) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);
		tratamento.setRemedio(remedio);
		return true;
	}

	public boolean adicionarExame(int exame, int idTratamento) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);
		tratamento.setExame(exame);
		return true;
	}

	public Remedio buscarRemedioPorID(int id) {
		this.getConnection().getEntityManager().clear();
		Remedio remedio = this.getConnection().getEntityManager().find(Remedio.class, id);
		if(remedio == null){
			System.out.println("Remedio não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return remedio;
	}

	public Exame buscarExamePorID(int id) {
		this.getConnection().getEntityManager().clear();
		Exame exame = this.getConnection().getEntityManager().find(Exame.class, id);
		if(exame == null){
			System.out.println("Exame não encontrado");
		}
		this.getConnection().getEntityManager().close();
		return exame;
	}

}