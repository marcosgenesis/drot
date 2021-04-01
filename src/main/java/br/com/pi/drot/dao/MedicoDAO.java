package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasMedico;

public interface MedicoDAO {
	ArrayList<ConsultasMedico> consultasRealizadas(int idMedico);
	String pegarNomeMedicoLogado(int idMedico);
}
