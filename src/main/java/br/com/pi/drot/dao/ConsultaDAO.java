package br.com.pi.drot.dao;

import java.sql.Date;

import br.com.pi.drot.model.MedicoModel;
import br.com.pi.drot.model.PacienteModel;

public interface ConsultaDAO{
	boolean cadastrarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta);

	boolean remarcarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta);

	boolean desmarcarConsulta(PacienteModel paciente, MedicoModel medico, Date dataConsulta);

	boolean buscarConsultaPorId(int id);
}
