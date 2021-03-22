package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;

public interface AdministradorDAO {

	boolean cadastrarUsuario(Paciente paciente);

	Paciente buscarUsuarioPorID(int id);

	ArrayList<Paciente> listarUsuarios();

	boolean editar(Paciente paciente);

	boolean removerPorId(int id);
}
