package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Remedio;

public interface ConsultaDAO{
	boolean cadastrarConsulta(Paciente paciente, Medico medico);

	boolean remarcarConsulta();

	boolean desmarcarConsulta();

	boolean buscarConsultaPorId(int id);
}
