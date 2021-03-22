package br.com.pi.drot.dao;

import br.com.pi.drot.model.MedicoModel;
import br.com.pi.drot.model.PacienteModel;

public interface ConsultaDAO{
	boolean cadastrarConsulta(PacienteModel paciente, MedicoModel medico);

	boolean remarcarConsulta();

	boolean desmarcarConsulta();

	boolean buscarConsultaPorId(int id);
}
