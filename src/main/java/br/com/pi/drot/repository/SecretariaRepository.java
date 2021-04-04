package br.com.pi.drot.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.SecretariaDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;
import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.utils.DataDoDia;

public class SecretariaRepository implements SecretariaDAO{
	private Connection connection;

	public SecretariaRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<ConsultasDoDia> consultasDoDia(int idPaciente, String dataDoDia) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
		TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataConsulta", dataDoDia);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();

		ArrayList<ConsultasDoDia> consultasDoDia = new ArrayList<ConsultasDoDia>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.getConnection().getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasDoDia.add(new ConsultasDoDia(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia(), consultas.size()));
		}

		for (int i = 0; i < consultasDoDia.size(); i++) {
			System.out.println(consultasDoDia.get(i));
		}

		return consultasDoDia;
	}

	public String pegarnomeSecretariaLogada(int idSecretaria) {
		String sqlConsulta = "SELECT s FROM Secretaria s WHERE s.id =: id";
		TypedQuery<Secretaria> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Secretaria.class).setParameter("id", idSecretaria);
		String nomeSecretariaLogada = queryConsultas.getSingleResult().getNome();
		return nomeSecretariaLogada;
	}


	public int quantidadeConsultasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();

        ArrayList<ConsultasDoDia> consultasDoDia = new ArrayList<ConsultasDoDia>();

        for (int i = 0; i < consultas.size(); i++) {
            consultasDoDia.add(new ConsultasDoDia(buscarNomePacientePorID(consultas.get(i).getPaciente()), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia(), consultas.size()));
        }

        return consultasDoDia.size();
	}

	public int quantidadeConsultasRealizadasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
        String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        int consultasRealizadas = 0;
        for (Consulta c: consultas) {
            if(c.getConsultaRealizada() ==  true) {
                consultasRealizadas++;
            }
        }
        return consultasRealizadas;
	}

	public int quantidadeConsultasNaoRealizadasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        int consultasRealizadas = 0;
        for (Consulta c: consultas) {
            if(c.getConsultaRealizada() ==  false) {
                consultasRealizadas++;
            }
        }
        return consultasRealizadas;
	}

	public boolean cadastrarNovoMedico(String nome, String CPF, String RG, String dataNascimento, int i, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();
		Medico medico = new Medico();
		medico.setNome(nome);
		medico.setCPF(CPF);
		medico.setRG(RG);
		medico.setDataNascimento(dataNascimento);
		medico.setEndereco(i);
		medico.setTelefone(telefone);
		medico.setEmail(email);
		medico.setSenha(senha);
		try {
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(medico);
			this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Nova(o) medico(a) cadastrado com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao criar médico.");
			return false;
		}
	}

	public Medico buscarMedicoPorID(int id) {
		this.getConnection().getEntityManager().clear();

		try{
			Medico medico = this.getConnection().getEntityManager().createNamedQuery("Medico.getById", Medico.class).setParameter(id, id).getSingleResult();

			return medico;
		} catch(NoResultException ex) {
			System.out.println("Médico não encontrado");
			return null;
		}
	}

	public int buscarMedicoPorCPF(String cpf) {
		this.getConnection().getEntityManager().clear();

		try {
			Medico medico = this.getConnection().getEntityManager().createNamedQuery("Medico.getIdByCpf", Medico.class).setParameter("cpf", cpf).getSingleResult();
			return medico.getId();
		} catch (NoResultException ex) {
			return -1;
		}
	}

	public ArrayList<Medico> listarMedicosCadastrados() {
		this.getConnection().getEntityManager().clear();
		this.getConnection().getEntityManager();

		try {
			ArrayList<Medico> medicos = (ArrayList<Medico>) this.getConnection().getEntityManager().createQuery("from Medico", Medico.class).getResultList();

			return medicos;
		}catch(NoResultException ex) {
			System.out.println("Não há médicos cadastrados em nosso banco de dados.");
			return null;
		}
	}

	public boolean removerMedico(int idMedico) {
		this.getConnection().getEntityManager().clear();

		Medico medico = this.buscarMedicoPorID(idMedico);

		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

		try{
		 	this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(medico);
	        this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Médico removido do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover médico.");
			return false;
		}
	}

	@Override
	public String buscarNomeMedicoPorID(int idMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cadastrarNovoPaciente(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String restricaoMedicamental, String doencaHereditaria, String email, String senha) {
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setCPF(CPF);
		paciente.setRG(RG);
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setSenha(senha);
		paciente.setDoencaHereditaria(doencaHereditaria);
		paciente.setRestricaoMedicamental(restricaoMedicamental);

		try{
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(paciente);
			this.getConnection().getEntityManager().getTransaction().commit();

		} catch(Exception ex) {
			System.out.println("Erro ao criar paciente.");
            return false;
		}

		System.out.println("Nova(o) paciente cadastrado com sucesso!");
		return true;
	}


	public boolean editarPaciente(int idPaciente, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();
		Paciente paciente = this.buscarPacientePorID(idPaciente);
		paciente.setEndereco(endereco);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setSenha(senha);
		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(paciente);
            this.getConnection().getEntityManager().getTransaction().commit();

    		System.out.println("Paciente editado com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao editar paciente.");
            return false;
        }
	}

	public Paciente buscarPacientePorID(int id) {
		this.getConnection().getEntityManager().clear();

		try{
			Paciente paciente = this.getConnection().getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter(id, id).getSingleResult();

			return paciente;
		} catch(NoResultException ex) {
			System.out.println("Paciente não encontrado");
			return null;
		}
	}

	public int buscarPacientePorCPF(String cpf) {
		this.getConnection().getEntityManager().clear();

		try {
			Paciente paciente = this.getConnection().getEntityManager().createNamedQuery("Paciente.getIdByCpf", Paciente.class).setParameter("cpf", cpf).getSingleResult();

			return paciente.getId();
		} catch (NoResultException e) {
			System.out.println("Paciente não encontrado");
			return -1;
		}
	}

	public ArrayList<Paciente> listarPacientesCadastrados() {
		this.getConnection().getEntityManager().clear();
		this.getConnection().getEntityManager();
		try {
			ArrayList<Paciente> pacientes = (ArrayList<Paciente>) this.getConnection().getEntityManager().createQuery("from Paciente", Paciente.class).getResultList();

			return pacientes;
		} catch (NoResultException e) {
			System.out.println("Não há pacientes cadastrados.");
			return null;
		}
	}

	public boolean removerPaciente(int idPaciente) {
		this.getConnection().getEntityManager().clear();
		Paciente paciente = this.buscarPacientePorID(idPaciente);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}
		try {
			this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(paciente);
	        this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Paciente removido do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover paciente.");
			return false;
		}
	}

	public boolean logado(String email, String pass) {
		try {
			Secretaria s = this.getConnection().getEntityManager().createNamedQuery("Secretaria.loginSecretaria", Secretaria.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public String buscarNomePacientePorID(int idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}
}
