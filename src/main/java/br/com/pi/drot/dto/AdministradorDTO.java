package br.com.pi.drot.dto;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.AdministradorDAO;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class AdministradorDTO implements AdministradorDAO{

	private Connection connection;

	public AdministradorDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarUsuario(Paciente paciente) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(paciente);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		return true;
	}

	@Override
	public Paciente buscarUsuarioPorID(int id) {
		Paciente paciente = this.getConnection().getEntityManager().find(Paciente.class, id);

		if(paciente == null){
			System.out.println("Usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return paciente;
	}

	@Override
	public ArrayList<Paciente> listarUsuarios() {
		this.getConnection().getEntityManager();
		ArrayList<Paciente> pacientes = (ArrayList<Paciente>) this.getConnection().getEntityManager().createQuery("from Paciente", Paciente.class).getResultList();
		this.getConnection().getEntityManager().close();

		return pacientes;
	}

	@Override
	public boolean editar(Paciente paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerPorId(int id) {
		Paciente paciente = this.getConnection().getEntityManager().find(Paciente.class, id);

		if(paciente == null){
			System.out.println("Usuário não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Paciente removido do banco com sucesso");

		return true;
	}

}
