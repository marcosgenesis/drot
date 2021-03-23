package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Administrador;

public class AdministradorModel extends GenericDAO<AdministradorModel> implements AdministradorDAO{
	private int id;
	private String nome;
	private String CPF;
	private String RG;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	private Connection connection;


	public AdministradorModel() {
        super(Administrador.class);
		this.connection = new Connection();

	}

	public AdministradorModel(int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone,
			String email, String senha) {
		super(Administrador.class);
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean cadastrarNovoAdministrador(AdministradorModel administrador) {
		if(this.cadastrarNovaInstancia(administrador)) {
			System.out.println("Novo administrador cadastrado com sucesso!");
			return true;
		}
		return false;
	}

	public boolean editarAdministrador(AdministradorModel administrador) {
		if(this.editarInstancia(administrador)) {
			System.out.println("Administrador editado com sucesso!");
			return true;
		}
		return false;
	}

	public AdministradorModel buscarAdministradorPorID(int id) {
		return this.obterPorId(id);
	}

	public ArrayList<AdministradorModel> listarAdministradoresCadastrados() {
		return this.listarInstancias();
	}

	public boolean cadastrarNovoPaciente(PacienteModel paciente) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(paciente);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo paciente cadastrado com sucesso!");
		return true;
	}


	public boolean editarPaciente(PacienteModel paciente) {
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

	public PacienteModel buscarPacientePorID(int id) {
		this.getConnection().getEntityManager().clear();

		PacienteModel paciente = this.getConnection().getEntityManager().find(PacienteModel.class, id);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return paciente;
	}

	public ArrayList<PacienteModel> listarPacientesCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<PacienteModel> pacientes = (ArrayList<PacienteModel>) this.getConnection().getEntityManager().createQuery("from Usuario", PacienteModel.class).getResultList();
		if(pacientes == null) {
			System.out.println("Não há pacientes cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return pacientes;
	}

	public boolean removerPaciente(PacienteModel paciente) {
		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}

	 	this.getConnection().getEntityManager().getTransaction().begin();
        this.getConnection().getEntityManager().remove(paciente);
        this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Paciente removido do banco com sucesso!");

		return true;
	}

	public boolean removerPacientePorId(int id) {
		PacienteModel paciente = this.getConnection().getEntityManager().find(PacienteModel.class, id);

		if(paciente == null){
			System.out.println("Paciente não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Paciente removido do banco com sucesso");

		return true;
	}

	public boolean cadastrarNovoMedico(MedicoModel medico) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(medico);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Novo médico cadastrado com sucesso!");
		return true;
	}

	public boolean editarMedico(MedicoModel medico) {
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

	public MedicoModel buscarMedicoPorID(int id) {
		this.getConnection().getEntityManager().clear();
		MedicoModel model = this.getConnection().getEntityManager().find(MedicoModel.class, id);
		if(model == null){
			System.out.println("Médico não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return model;
	}

	public ArrayList<MedicoModel> listarMedicosCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<MedicoModel> medicos = (ArrayList<MedicoModel>) this.getConnection().getEntityManager().createQuery("from Usuario", MedicoModel.class).getResultList();
		if(medicos == null) {
			System.out.println("Não há médicos cadastrados em nosso banco de dados.");
		}
		this.getConnection().getEntityManager().close();

		return medicos;
	}

	public boolean removerMedico(MedicoModel medico) {
		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

	 	this.getConnection().getEntityManager().getTransaction().begin();
        this.getConnection().getEntityManager().remove(medico);
        this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Médico removido do banco com sucesso!");

		return true;
	}

	public boolean removerMedicoPorId(int id) {
		MedicoModel medico = this.getConnection().getEntityManager().find(MedicoModel.class, id);

		if(medico == null){
			System.out.println("Médico não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Médico removido do banco com sucesso");

		return true;
	}

	public boolean cadastrarNovaSecretaria(SecretariaModel secretaria) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(secretaria);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		System.out.println("Nova secretária cadastrada com sucesso!");
		return false;
	}

	public boolean editarSecretaria(SecretariaModel secretaria) {
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

	public SecretariaModel buscarSecretariaPorID(int id) {
		this.getConnection().getEntityManager().clear();

		SecretariaModel secretaria = this.getConnection().getEntityManager().find(SecretariaModel.class, id);

		if(secretaria == null){
			System.out.println("Secretária não encontrada");
		}

		this.getConnection().getEntityManager().close();
		return secretaria;
	}

	public ArrayList<SecretariaModel> listarSecretariasCadastrados() {
		this.getConnection().getEntityManager().clear();
		this.getConnection().getEntityManager();
		ArrayList<SecretariaModel> secretarias = (ArrayList<SecretariaModel>) this.getConnection().getEntityManager().createQuery("from Usuario", SecretariaModel.class).getResultList();
		this.getConnection().getEntityManager().close();

		return secretarias;
	}


	public boolean removerSecretaria(SecretariaModel secretaria) {
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
		SecretariaModel secretaria = this.getConnection().getEntityManager().find(SecretariaModel.class, id);

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

	public AdministradorModel isAutentico(int id, String senha) {
		 AdministradorModel administrador = obterAdministrador(id);
	        if (administrador != null) {
	            if (administrador.getSenha().equals(senha)) {
	                return administrador;
	            }
	        }
	        return null;
	}

	public boolean logado(String email, String pass) {
		/*String sql = "SELECT nome, email FROM Administrador WHERE email = :emailUser AND senha = :senhaUser";

		String emailUser = email;
		String senhaUser  = pass;

		Query query = (Query) this.getConnection().getEntityManager().createQuery(sql, Administrador.class);
		Administrador adm = (Administrador) ((javax.persistence.Query) query).getResultList();

		if (adm == null) {
			return false;
		} else {
			return true;
		}*/

		Administrador adm = entityManager.find(Administrador.class, 1);

		if (adm == null) {
			return false;
		} else {
			return true;
		}
	}

	public AdministradorModel obterAdministrador(int id) {
		  this.getConnection().getEntityManager().clear();
	      return (AdministradorModel) entityManager.find(AdministradorModel.class, id);
	}
}
