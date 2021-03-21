package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Usuario;

public interface UsuarioDAO {

	boolean cadastrarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorID(int id);

	ArrayList<Usuario> listarUsuarios();

	boolean editar(Usuario usuario);

	boolean removerPorId(int id);

	boolean removerPorUsuario(Usuario usuario);

}
