package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.UsuarioDAO;
import br.com.pi.drot.entity.Usuario;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class UsuarioDTO implements UsuarioDAO{

	private Connection connection;

	public UsuarioDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean cadastrarUsuario(Usuario usuario) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(usuario);
		this.getConnection().getEntityManager().getTransaction().commit();

		this.getConnection().getEntityManager().close();

		return true;
	}

	public Usuario buscarUsuarioPorID(int id) {
		return null;
	}

	public ArrayList<Usuario> listarUsuarios() {
		this.getConnection().getEntityManager();
		ArrayList<Usuario> usuarios= (ArrayList<Usuario>) this.getConnection().getEntityManager().createQuery("from Usuario", Usuario.class).getResultList();
		this.getConnection().getEntityManager().close();

		return usuarios;
	}

	public boolean editar(Usuario usuario) {
		return false;
	}

	public boolean removerPorId(int id) {
		return false;
	}

	public boolean removerPorUsuario(Usuario usuario) {
		return false;
	}

}
