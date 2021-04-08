package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasPaciente;

public interface RelatorioConsultasPacienteDAO {

	ArrayList<ConsultasPaciente> consultasPaciente(int idPaciente);

}
