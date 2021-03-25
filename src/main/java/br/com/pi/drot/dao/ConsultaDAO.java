package br.com.pi.drot.dao;

import java.sql.Date;

import br.com.pi.drot.model.MedicoRepository;
import br.com.pi.drot.model.PacienteRepository;

public interface ConsultaDAO{
	boolean cadastrarConsulta(PacienteRepository paciente, MedicoRepository medico, Date dataConsulta);

	boolean remarcarConsulta(PacienteRepository paciente, MedicoRepository medico, Date dataConsulta);

	boolean desmarcarConsulta(PacienteRepository paciente, MedicoRepository medico, Date dataConsulta);

	boolean buscarConsultaPorId(int id);
}
