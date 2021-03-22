package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;

public interface PacienteDAO {

	Paciente buscarUsuarioPorID(int id);

	ArrayList<Paciente> listarUsuarios();

	void preencherDadosRegistros(String restricaoMedicamental, String doencaHereditaria);

}
