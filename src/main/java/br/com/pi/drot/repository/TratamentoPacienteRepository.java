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

	public boolean criarTratamentoPaciente(Paciente paciente, Remedio remedio, Exame exame, Date inicioTratamento, Date fimTratamento) {
		TratamentoPaciente tratamento = new TratamentoPaciente();
		tratamento.adicionarExame(tratamento, exame);
		tratamento.adicionarRemedio(tratamento, remedio);
		tratamento.setPaciente(paciente.getId());
		tratamento.setInicioTratamento(inicioTratamento);
		tratamento.setFimTratamento(fimTratamento);

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

	public boolean editarTratamentoPacienteAdicionarRemedio(TratamentoPaciente tratamento, Remedio remedio) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.adicionarRemedio(tratamento, remedio);

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


	public boolean editarTratamentoPacienteRemoverRemedio(TratamentoPaciente tratamento, Remedio remedio) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.removerRemedio(tratamento, remedio);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao remover remedio do tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	 public boolean editarTratamentoPacienteAdicionarExame(TratamentoPaciente tratamento, Exame exame) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.adicionarExame(tratamento, exame);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao adicionar exame ao tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean editarTratamentoPacienteRemoverExame(TratamentoPaciente tratamento, Exame exame) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.removerExame(tratamento, exame);

		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(tratamento);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao remover exame do tratamento do paciente");
            return false;
        }

		System.out.println("Tratamento editado com sucesso!");

        return true;
	}

	public boolean editarTratamentoPacienteAlterarFimTratamento(TratamentoPaciente tratamento, Date fimTratamento) {
		if(tratamento == null){
			System.out.println("Tratamento para o usuário não encontrado");
			return false;
		}

		tratamento.setFimTratamento(fimTratamento);

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

	public boolean removerTratamentoṔaciente(TratamentoPaciente tratamento) {
		if(tratamento == null){
			System.out.println("Tratamento para paciente não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().remove(tratamento.getId());
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Tratamento removido do banco com sucesso");

		return true;
	}

}