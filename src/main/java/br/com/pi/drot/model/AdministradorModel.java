package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.utils.NameDataBaseConnection;

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


	public AdministradorModel(NameDataBaseConnection nameDataBaseConnection) {
        super(Administrador.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());

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

	public boolean cadastrarNovoPaciente(PacienteModel paciente) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(paciente);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();
		return false;
	}


	public boolean editarPaciente(PacienteModel paciente) {
		return false;
	}

	public PacienteModel buscarPacientePorID(int id) {
		PacienteModel paciente = this.getConnection().getEntityManager().find(PacienteModel.class, id);

		if(paciente == null){
			System.out.println("Usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return paciente;
	}

	public ArrayList<PacienteModel> listarPacientesCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<PacienteModel> pacientes = (ArrayList<PacienteModel>) this.getConnection().getEntityManager().createQuery("from Usuario", PacienteModel.class).getResultList();
		this.getConnection().getEntityManager().close();

		return pacientes;
	}

	public boolean removerPaciente(PacienteModel paciente) {
		return false;
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
		return false;
	}

	public boolean editarMedico(MedicoModel medico) {
		return false;
	}

	public MedicoModel buscarMedicoPorID(int id) {
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
		this.getConnection().getEntityManager().close();

		return medicos;
	}

	public boolean removerMedico(MedicoModel medico) {
		return false;
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
		return false;
	}

	public boolean editarSecretaria(SecretariaModel secretaria) {
		return false;
	}

	public MedicoModel buscarSecretariaPorID(int id) {
		return null;
	}

	public ArrayList<SecretariaModel> listarSecretariasCadastrados() {
		this.getConnection().getEntityManager();
		ArrayList<SecretariaModel> secretarias = (ArrayList<SecretariaModel>) this.getConnection().getEntityManager().createQuery("from Usuario", SecretariaModel.class).getResultList();
		this.getConnection().getEntityManager().close();

		return secretarias;
	}


	public boolean removerSecretaria(SecretariaModel secretaria) {
		return false;
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
		 AdministradorModel administrador = obter(id);
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

	public AdministradorModel obter(int id) {
	      entityManager.clear();
	      return (AdministradorModel) entityManager.find(AdministradorModel.class, id);
	 }

	public AdministradorModel isAutentico(AdministradorModel administrador) {
        return isAutentico(administrador.getId(), administrador.getSenha());
    }

	public AdministradorModel isAutentico(String ra, String senha) {
	return null;
	}

}
