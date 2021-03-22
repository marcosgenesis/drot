package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;

public interface MedicoDAO {

	void consultarPaciente(Paciente usuario);

	void editarHistoricoPaciente(int id);

	ArrayList<Paciente> listarUsuarios();

	boolean editar(Paciente paciente);

	boolean removerPorId(int id);

	boolean removerPorUsuario(Paciente paciente);
}
