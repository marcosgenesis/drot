package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.EnfermeiroDAO;
import br.com.pi.drot.entity.Paciente;

public class EnfermeiroRepository implements EnfermeiroDAO{

	Connection connection = Connection.getConnection();

	public EnfermeiroRepository() {}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conexao) {
		this.connection = Connection.getConnection();
		this.connection = conexao;
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


	@Override
	public String buscarNomePacientePorID(int idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

}