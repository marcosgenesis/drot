package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

@SuppressWarnings("all")
public class AdministradorRepository implements AdministradorDAO{
	private Connection connection;

	public AdministradorRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();
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

		} catch(Exception ex) {
			System.out.println("Erro ao criar administrador.");
            return false;
		}

		System.out.println("Novo administrador cadastrado com sucesso!");
		return true;
	}

	public Administrador buscarAdministradorPorID(int id) {
		this.getConnection().getEntityManager().clear();
		try{
			Administrador administrador = this.getConnection().getEntityManager().createNamedQuery("Administrador.getById", Administrador.class).setParameter(id, id).getSingleResult();

			return administrador;
		} catch(NoResultException ex) {
			System.out.println("Administrador não encontrado");
			return null;
		}
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

	public boolean editarMedico(int idMedico, int endereco, String telefone, String email, String senha ) {
		this.getConnection().getEntityManager().clear();
		Medico medico = this.buscarMedicoPorID(idMedico);
		medico.setEndereco(endereco);
		medico.setTelefone(telefone);
		medico.setEmail(email);
		medico.setSenha(senha);

		try {
	            this.getConnection().getEntityManager().getTransaction().begin();
	            this.getConnection().getEntityManager().merge(medico);
	            this.getConnection().getEntityManager().getTransaction().commit();

	    		System.out.println("Médico editado com sucesso!");
		        return true;
	        } catch (Exception ex) {
	    		System.out.println("Erro ao editar médico.");
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

	public boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();

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

			System.out.println("Nova(o) secretaria(o) cadastrado com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao criar secretaria.");
			return false;
		}
	}

	public boolean editarSecretaria(int idSecretaria, int endereco, String telefone, String email, String senha) {
		this.getConnection().getEntityManager().clear();

		Secretaria secretaria = this.buscarSecretariaPorID(idSecretaria);
		secretaria.setEndereco(endereco);
		secretaria.setTelefone(telefone);
		secretaria.setEmail(email);
		secretaria.setSenha(senha);
		try {
            this.getConnection().getEntityManager().getTransaction().begin();
            this.getConnection().getEntityManager().merge(secretaria);
            this.getConnection().getEntityManager().getTransaction().commit();

    		System.out.println("Secretária editada com sucesso!");
            return true;
        } catch (Exception ex) {
    		System.out.println("Erro ao editar secretária.");
            return false;
        }
    }

	public Secretaria buscarSecretariaPorID(int id) {
		this.getConnection().getEntityManager().clear();

		try{
			Secretaria secretaria = this.getConnection().getEntityManager().createNamedQuery("Secretaria.getById", Secretaria.class).setParameter(id, id).getSingleResult();

			return secretaria;
		} catch(NoResultException ex) {
			System.out.println("Secretária não encontrada");
			return null;
		}
	}

	public ArrayList<Secretaria> listarSecretariasCadastrados() {
		this.getConnection().getEntityManager().clear();
		try {
			ArrayList<Secretaria> secretarias = (ArrayList<Secretaria>) this.getConnection().getEntityManager().createQuery("from Secretaria", Secretaria.class).getResultList();

			return secretarias;
		}catch(NoResultException ex) {
			System.out.println("Não há secretaria cadastradas em nosso banco de dados.");
			return null;
		}
	}

	public boolean removerSecretaria(int idSecretaria) {
		this.getConnection().getEntityManager().clear();
		Secretaria secretaria = this.buscarSecretariaPorID(idSecretaria);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
			return false;
		}

		try{
		 	this.getConnection().getEntityManager().getTransaction().begin();
	        this.getConnection().getEntityManager().remove(secretaria);
	        this.getConnection().getEntityManager().getTransaction().commit();

			System.out.println("Secretária removida do banco com sucesso!");
			return true;
		} catch(Exception ex) {
			System.out.println("Erro ao remover secretária.");
			return false;
		}
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
