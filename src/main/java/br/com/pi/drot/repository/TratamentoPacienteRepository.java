package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.entity.TratamentoPaciente;
import br.com.pi.drot.models.TratamentosPaciente;

public class TratamentoPacienteRepository implements TratamentoPacienteDAO{
	Connection connection = Connection.getInstance();

	public TratamentoPacienteRepository(){}

	public boolean criarTratamentoPaciente(int idPaciente, String dataInicioTratamento, int tempoTratamento) {
		TratamentoPaciente tratamento = new TratamentoPaciente();
		tratamento.setPaciente(idPaciente);
		tratamento.setTempoTratamento(tempoTratamento);
		tratamento.setDataInicioTratamento(dataInicioTratamento);
		tratamento.setEstadoTratamento(false);
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(tratamento);
		this.connection.getEntityManager().getTransaction().commit();

		System.out.println("Novo tratamento cadastrado com sucesso!" +tratamento.getId());
		return true;
	}

	public TratamentoPaciente buscarTratamentoPacientePorID(int id) {
		try {
			TratamentoPaciente tratamento = this.connection.getEntityManager().createNamedQuery("TratamentoPaciente.getById", TratamentoPaciente.class).setParameter("cod", id).getSingleResult();
			return tratamento;
		} catch (NoResultException e) {
			return null;
		}
	}

	public ArrayList<TratamentoPaciente> listarTratamentosPaciente() {
		this.connection.getEntityManager();
		ArrayList<TratamentoPaciente> tratamentos = (ArrayList<TratamentoPaciente>) this.connection.getEntityManager().createQuery("from TratamentoPaciente", TratamentoPaciente.class).getResultList();
		if(tratamentos == null) {
			System.out.println("Não há tratamentos cadastrados em nosso banco de dados.");
		}


		return tratamentos;
	}

	public boolean editarTratamentoPacienteAdicionarRemedio(int idTratamento, int idRemedio) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		this.adicionarRemedio(idRemedio, idTratamento);

		try {
            this.connection.getEntityManager().getTransaction().begin();
            this.connection.getEntityManager().merge(tratamento);
            this.connection.getEntityManager().getTransaction().commit();

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

		this.adicionarExame(idExame, idTratamento);

		try {
            this.connection.getEntityManager().getTransaction().begin();
            this.connection.getEntityManager().merge(tratamento);
            this.connection.getEntityManager().getTransaction().commit();

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
            this.connection.getEntityManager().getTransaction().begin();
            this.connection.getEntityManager().merge(tratamento);
            this.connection.getEntityManager().getTransaction().commit();

        } catch (Exception ex) {
    		System.out.println("Erro editar a data final de tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean removerTratamentoPacientePorId(int id) {
		TratamentoPaciente tratamento = this.connection.getEntityManager().find(TratamentoPaciente.class, id);

		if(tratamento == null){
			System.out.println("Tratamento para paciente não encontrado");
			return false;
		}

		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().remove(id);
		this.connection.getEntityManager().getTransaction().commit();


		System.out.println("Tratamento removido do banco com sucesso");

		return true;
	}

	public boolean adicionarRemedio(int remedio, int idTratamento) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);

		if (tratamento != null) {
			System.out.println("Aqui 2");
			tratamento.setRemedio(remedio);

			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().merge(tratamento);
			this.connection.getEntityManager().getTransaction().commit();


			return true;
		}

		return false;
	}

	public boolean adicionarExame(int exame, int idTratamento) {
		TratamentoPaciente tratamento = buscarTratamentoPacientePorID(idTratamento);

		if (tratamento != null) {
			System.out.println("Aqui 1");
			tratamento.setExame(exame);

			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().merge(tratamento);
			this.connection.getEntityManager().getTransaction().commit();


			return true;
		}

		return false;
	}

	public ArrayList<TratamentosPaciente> tratamentosPaciente(int idPaciente) {
		String sqlConsulta = "SELECT t FROM TratamentoPaciente t WHERE t.paciente =: id";
		TypedQuery<TratamentoPaciente> queryTratamentos = this.connection.getEntityManager().createQuery(sqlConsulta, TratamentoPaciente.class).setParameter("id", idPaciente);
		ArrayList<TratamentoPaciente> tratamentos = (ArrayList<TratamentoPaciente>) queryTratamentos.getResultList();


		ArrayList<TratamentosPaciente> tratamentosPrescritos = new ArrayList<TratamentosPaciente>();

		for (int i = 0; i < tratamentos.size(); i++) {
			tratamentosPrescritos.add(new TratamentosPaciente(tratamentos.get(i).getDuracaoDiasTratamento(), tratamentos.get(i).getDataInicioTratamento(), tratamentos.get(i).getPaciente() ));
		}
		return tratamentosPrescritos;
	}

}