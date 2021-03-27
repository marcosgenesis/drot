package br.com.pi.drot.repository;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

@SuppressWarnings("all")
public class AdministradorRepository extends GenericDAO<Administrador> implements AdministradorDAO{
	private Connection connection;

	public AdministradorRepository() {
        super(Administrador.class);
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String email, String senha) {
		Administrador administrador = new Administrador();
		administrador.setNome(nome);
		administrador.setCPF(CPF);
		administrador.setRG(RG);
		administrador.setDataNascimento(dataNascimento);
		administrador.setEndereco(endereco);
		administrador.setTelefone(telefone);
		administrador.setEmail(email);
		administrador.setSenha(senha);
		try{
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(administrador);
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();
		} catch(Exception ex) {
			System.out.println("Erro ao criar administrador.");
            return false;
		}

		System.out.println("Novo administrador cadastrado com sucesso!");
		return true;
	}

	public boolean editarAdministrador(Administrador administrador) {
		   try {
	            this.getConnection().getEntityManager().getTransaction().begin();
	            this.getConnection().getEntityManager().merge(administrador);
	            this.getConnection().getEntityManager().getTransaction().commit();
	    		this.getConnection().getEntityManager().close();
	        } catch (Exception ex) {
	    		System.out.println("Erro ao editar administrador.");
	            return false;
	        }
			System.out.println("Administrador editado com sucesso!");
	        return true;
	}

	public Administrador buscarAdministradorPorID(int id) {
		this.getConnection().getEntityManager().clear();

		Administrador administrador = this.getConnection().getEntityManager().find(Administrador.class, id);

		if(administrador == null){
			System.out.println("Administrador não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return administrador;
	}

	public ArrayList<Administrador> listarAdministradoresCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<Administrador> administradores = (ArrayList<Administrador>) this.getConnection().getEntityManager().createQuery("from Administrador", Administrador.class).getResultList();

		if(administradores == null) {
			System.out.println("Não há administradores cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return administradores;
	}

	public boolean cadastrarNovoPaciente(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String restricaoMedicamental, String doencaHereditaria, String email, String senha) {
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setCPF(CPF);
		paciente.setRG(RG);
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setSenha(senha);
		paciente.setRestricaoMedicamental(restricaoMedicamental);
		paciente.setSenha(doencaHereditaria);
		try{
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(paciente);
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();
		} catch(Exception ex) {
			System.out.println("Erro ao criar paciente.");
            return false;
		}

		System.out.println("Nova(o) paciente cadastrado com sucesso!");
		return true;
	}


	public boolean editarPaciente(Paciente paciente) {
	    try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(paciente);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao editar paciente.");
            return false;
        }

		System.out.println("Paciente editado com sucesso!");

        return true;
	}

	public Paciente buscarPacientePorID(int id) {
		this.getConnection().getEntityManager().clear();

		Paciente paciente = this.getConnection().getEntityManager().find(Paciente.class, id);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return paciente;
	}

	public ArrayList<Paciente> listarPacientesCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<Paciente> pacientes = (ArrayList<Paciente>) this.getConnection().getEntityManager().createQuery("from Paciente", Paciente.class).getResultList();
		if(pacientes == null) {
			System.out.println("Não há pacientes cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return pacientes;
	}

	public boolean removerPaciente(Paciente paciente) {
		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}

		try {
			this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(paciente);
	        this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();

		} catch(Exception ex) {
			System.out.println("Erro ao remover paciente.");
			return false;
		}

		System.out.println("Paciente removido do banco com sucesso!");

		return true;
	}

	public boolean removerPacientePorId(int id) {
		Paciente paciente = this.getConnection().getEntityManager().find(Paciente.class, id);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}

		try {
			this.getConnection().getEntityManager().remove(id);
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();

		} catch(Exception ex) {
			System.out.println("Erro ao remover paciente.");
			return false;
		}

		System.out.println("Paciente removido do banco com sucesso");

		return true;
	}

	public boolean cadastrarNovoMedico(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String email, String senha) {
		Medico medico = new Medico();

		medico.setNome(nome);
		medico.setCPF(CPF);
		medico.setRG(RG);
		medico.setDataNascimento(dataNascimento);
		medico.setEndereco(endereco);
		medico.setTelefone(telefone);
		medico.setEmail(email);
		medico.setSenha(senha);

		try {
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(medico);
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();

		} catch(Exception ex) {
			System.out.println("Erro ao criar médico.");
			return false;
		}


		System.out.println("Nova(o) medico(a) cadastrado com sucesso!");
		return true;
	}

	public boolean editarMedico(Medico medico) {
		 try {
	            this.getConnection().getEntityManager().getTransaction().begin();
	            this.getConnection().getEntityManager().merge(medico);
	            this.getConnection().getEntityManager().getTransaction().commit();
	    		this.getConnection().getEntityManager().close();
	        } catch (Exception ex) {
	    		System.out.println("Erro ao editar médico.");
	            return false;
	        }

			System.out.println("Médico editado com sucesso!");

	        return true;
	}

	public Medico buscarMedicoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		Medico medico = this.getConnection().getEntityManager().find(Medico.class, id);
		if(medico == null){
			System.out.println("Médico não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return medico;
	}

	public ArrayList<Medico> listarMedicosCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<Medico> medicos = (ArrayList<Medico>) this.getConnection().getEntityManager().createQuery("from Medico", Medico.class).getResultList();
		if(medicos == null) {
			System.out.println("Não há médicos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return medicos;
	}

	public boolean removerMedico(Medico medico) {
		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

		try{
		 	this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(medico);
	        this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();
		} catch(Exception ex) {
			System.out.println("Erro ao remover médico.");
			return false;
		}

		System.out.println("Médico removido do banco com sucesso!");
		return true;
	}

	public boolean removerMedicoPorId(int id) {
		Medico medico = this.getConnection().getEntityManager().find(Medico.class, id);

		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

		try{
			this.getConnection().getEntityManager().remove(id);
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();
		} catch(Exception ex) {
			System.out.println("Erro ao remover médico.");
			return false;
		}
		System.out.println("Médico removido do banco com sucesso");

		return true;
	}

	public boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String email, String senha) {
		Secretaria secretaria = new Secretaria();

		secretaria.setNome(nome);
		secretaria.setCPF(CPF);
		secretaria.setRG(RG);
		secretaria.setDataNascimento(dataNascimento);
		secretaria.setEndereco(endereco);
		secretaria.setTelefone(telefone);
		secretaria.setEmail(email);
		secretaria.setSenha(senha);

		try {
			this.getConnection().getEntityManager().getTransaction().begin();
			this.getConnection().getEntityManager().persist(secretaria);
			this.getConnection().getEntityManager().getTransaction().commit();
			this.getConnection().getEntityManager().close();

		} catch(Exception ex) {
			System.out.println("Erro ao criar secretaria.");
			return false;
		}


		System.out.println("Nova(o) secretaria(o) cadastrado com sucesso!");
		return true;
	}

	public boolean editarSecretaria(Secretaria secretaria) {
	   try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(secretaria);
            this.getConnection().getEntityManager().getTransaction().commit();
    		this.getConnection().getEntityManager().close();
        } catch (Exception ex) {
    		System.out.println("Erro ao editar secretária.");
            return false;
        }

		System.out.println("Secretária editada com sucesso!");

        return true;
    }

	public Secretaria buscarSecretariaPorID(int id) {
		this.getConnection().getEntityManager().clear();

		Secretaria secretaria = this.getConnection().getEntityManager().find(Secretaria.class, id);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
		}

		this.getConnection().getEntityManager().close();
		return secretaria;
	}

	public ArrayList<Secretaria> listarSecretariasCadastrados() {
		this.getConnection().getEntityManager().clear();
		this.getConnection().getEntityManager();
		ArrayList<Secretaria> secretarias = (ArrayList<Secretaria>) this.getConnection().getEntityManager().createQuery("from Secretaria", Secretaria.class).getResultList();
		this.getConnection().getEntityManager().close();

		return secretarias;
	}


	public boolean removerSecretaria(Secretaria secretaria) {
		if(secretaria == null){
			System.out.println("Secretária não encontrada");
			return false;
		}

	 	this.getConnection().getEntityManager().getTransaction().begin();
        this.getConnection().getEntityManager().remove(secretaria);
        this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Secretária removida do banco com sucesso!");

		return true;
	}

	public boolean removerSecretariaPorId(int id) {
		Secretaria secretaria = this.getConnection().getEntityManager().find(Secretaria.class, id);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Secretária removido do banco com sucesso");

		return true;
	}

	public boolean logado(String email, String pass) {
		try {
			Administrador a = this.getConnection().getEntityManager().createNamedQuery("Administrador.loginAdm", Administrador.class).setParameter("email", email).setParameter("senha", pass).getSingleResult();

			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

}
