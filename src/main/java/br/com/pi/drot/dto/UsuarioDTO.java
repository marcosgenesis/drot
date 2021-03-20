package br.com.pi.drot.dto;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.pi.drot.dao.JpaUtils;
import br.com.pi.drot.dao.UsuarioDAO;
import br.com.pi.drot.model.Usuario;

public class UsuarioDTO implements UsuarioDAO{

	public boolean cadastrarUsuario(Usuario usuario) {
		EntityManager entityManager = (EntityManager) JpaUtils.getEntityManager();

		entityManager.persist(usuario);

		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();

		entityManager.close();


		return true;
	}

	public Usuario buscarUsuarioPorID(int id) {
		return null;
	}

	public ArrayList<Usuario> listarUsuarios() {
		EntityManager entityManager = (EntityManager) JpaUtils.getEntityManager();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("from Usuario", Usuario.class).getResultList();
		entityManager.close();
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
