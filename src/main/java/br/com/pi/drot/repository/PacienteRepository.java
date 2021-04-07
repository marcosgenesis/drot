package br.com.pi.drot.repository;

import java.text.ParseException;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.PacienteDAO;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.utils.CalcularIdade;

public class PacienteRepository implements PacienteDAO{
	Connection connection = Connection.getInstance();

	public PacienteRepository() {}

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
			this.connection.getEntityManager().getTransaction().begin();
			this.connection.getEntityManager().persist(paciente);
			this.connection.getEntityManager().getTransaction().commit();

		} catch(Exception ex) {
			System.out.println("Erro ao criar paciente.");
            return false;
		}

		System.out.println("Nova(o) paciente cadastrado com sucesso!");
		return true;
	}


	public boolean editarPaciente(int idPaciente, int endereco, String telefone, String email, String senha) {
		this.connection.getEntityManager().clear();
		Paciente paciente = this.buscarPacientePorID(idPaciente);
		paciente.setEndereco(endereco);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setSenha(senha);
		try {
            this.connection.getEntityManager().getTransaction().begin();
            this.connection.getEntityManager().merge(paciente);
            this.connection.getEntityManager().getTransaction().commit();

    		System.out.println("Paciente editado com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao editar paciente.");
            return false;
        }
	}

	public Paciente buscarPacientePorID(int id) {
		this.connection.getEntityManager().clear();

		try{
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter(id, id).getSingleResult();

			return paciente;
		} catch(NoResultException ex) {
			System.out.println("Paciente não encontrado");
			return null;
		}
	}

	public int buscarPacientePorCPF(String cpf) {
		this.connection.getEntityManager().clear();

		try {
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getIdByCpf", Paciente.class).setParameter("cpf", cpf).getSingleResult();

			return paciente.getId();
		} catch (NoResultException e) {
			System.out.println("Paciente não encontrado");
			return -1;
		}
	}

	public ArrayList<Paciente> listarPacientesCadastrados() {
		this.connection.getEntityManager().clear();
		this.connection.getEntityManager();
		try {
			ArrayList<Paciente> pacientes = (ArrayList<Paciente>) this.connection.getEntityManager().createQuery("from Paciente", Paciente.class).getResultList();

			return pacientes;
		} catch (NoResultException e) {
			System.out.println("Não há pacientes cadastrados.");
			return null;
		}
	}

	public boolean removerPaciente(int idPaciente) {
		this.connection.getEntityManager().clear();
		Paciente paciente = this.buscarPacientePorID(idPaciente);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}
		try {
			this.connection.getEntityManager().getTransaction().begin();
	        this.connection.getEntityManager().remove(paciente);
	        this.connection.getEntityManager().getTransaction().commit();

			System.out.println("Paciente removido do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover paciente.");
			return false;
		}
	}

	public String pegarNomePacienteLogado(int idPaciente) {
		String sqlConsulta = "SELECT p FROM Paciente p WHERE p.id =: id";
		TypedQuery<Paciente> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Paciente.class).setParameter("id", idPaciente);
		String nomePacienteLogado = queryConsultas.getSingleResult().getNome();
		return nomePacienteLogado;
	}

	public int pegarIdadePaciente(int idPaciente) {
		String sqlConsulta = "SELECT p FROM Paciente p WHERE p.id =: id";
		TypedQuery<Paciente> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Paciente.class).setParameter("id", idPaciente);
		String dataNascimento = queryConsultas.getSingleResult().getDataNascimento();
	    try {
			CalcularIdade calcularIdade = new CalcularIdade();
			return calcularIdade.calcularIdade(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    return 0;
	}
}

