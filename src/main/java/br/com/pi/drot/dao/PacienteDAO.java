package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;

public interface PacienteDAO {

	boolean login();

	boolean logout();

	void preencherDadosRegistros(String restricaoMedicamental, String doencaHereditaria);

}
