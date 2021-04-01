package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasPaciente;

public interface PacienteDAO {
	ArrayList<ConsultasPaciente> consultasPaciente(int idPaciente);
	String pegarNomePacienteLogado(int idPaciente);
}
