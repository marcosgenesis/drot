package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.models.ConsultasMedico;

public interface RelatorioConsultasMedicoDAO {
	ArrayList<ConsultasDoDia> consultasDiariasMedico(int idMedico, String dataDoDia);

	int quantidadeConsultasDiariasDoMedico(int medico, String dataDoDia);

	int pegarNumPacientesDoMedico(int idMedico);

	ArrayList<ConsultasMedico> consultasRealizadasDoMedico(int idMedico);
}
