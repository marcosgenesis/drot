package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.model.AdministradorModel;
import br.com.pi.drot.model.MedicoModel;
import br.com.pi.drot.model.PacienteModel;
import br.com.pi.drot.model.SecretariaModel;
import br.com.pi.drot.utils.NameDataBaseConnection;
import br.edu.utfpr.biblioteca.salas.model.entity.UsuarioPO;

public class AdministradorDTO extends GenericDAO<AdministradorModel> implements AdministradorDAO{

	private Connection connection;

	public AdministradorDTO(NameDataBaseConnection nameDataBaseConnection) {
        super(AdministradorModel.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
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

	 public AdministradorModel obter(int id) {
	        entityManager.clear();
	        return (AdministradorModel) entityManager.find(AdministradorModel.class, id);
	 }

   public AdministradorModel isAutentico(AdministradorModel administrador) {
        return isAutentico(administrador.getId(), administrador.getSenha());
    }

}
