package br.com.pi.drot.dao;

import java.sql.Date;

import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;

public interface ConsultaDAO{
	boolean criarConsulta(Paciente paciente, Medico medico, Date dataConsulta);

	boolean remarcarConsulta(Consulta consulta, Date dataConsulta);

	boolean desmarcarConsulta(Consulta consulta);

	Consulta buscarConsultaPorId(int id);
}