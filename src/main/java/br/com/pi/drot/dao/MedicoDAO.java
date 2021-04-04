package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.models.ConsultasMedico;

public interface MedicoDAO {
	ArrayList<ConsultasMedico> consultasRealizadas(int idMedico);
	String pegarNomeMedicoLogado(int idMedico);
	ArrayList<ConsultasDoDia> consultasDoDia(int idMedico, String dataDoDia);
	int quantidadeConsultasDoDia(int medico, String dataDoDia);
	int pegarNumPacientes(int idMedico);
	boolean logado(String email, String pass);
 	int pegarIdMedico(String cpf);
}
